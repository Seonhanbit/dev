#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
PyFingerprint
Copyright (C) 2015 Bastian Raschke <bastian.raschke@posteo.de>
All rights reserved.

"""

import tempfile
from pyfingerprint.pyfingerprint import PyFingerprint
import os
import time
import argparse


'''
지문센서로 부터 지문 이미지를 얻어와 라즈베리파이에 path로 저장하는 코드

최종 수정일 2020.02.12 13:32
박종수

'''




def save_finger(path, gender):
    print('start files')
    try:
        '''
        usb port에 연결하여 지문센서 연결 여부를 확인
        '''
        f = PyFingerprint('/dev/ttyUSB0', 57600, 0xFFFFFFFF, 0x00000000)
        print('get print')
        # if ( f.verifyPassword() == False ):
        #   raise ValueError('The given fingerprint sensor password is wrong!')

    except Exception as e:
        print('The fingerprint sensor could not be initialized!')
        print('Exception message: ' + str(e))
        #exit(1)
        return "01"

    ## Gets some sensor information
    # print('Currently used templates: ' + str(f.getTemplateCount()) +'/'+ str(f.getStorageCapacity()))

    startTime = time.time()
    print(startTime)
    ## Tries to read image and download it
    try:
        '''
        지문을 인식할 때 까지 대가하는 코드
        '''
        print('Waiting for finger...')

        ## Wait that finger is read
        while (f.readImage() == False):
            if startTime-time.time() > 10000:
                return "03"
            pass

        print('Downloading image (this take a while)...')

        '''
        지문 센서로 부터 이미지를 얻어서 imageDestination에 저장하는 코드
        현재 imageDestination은 라즈베리파이의 root폴더 아래의 tmp폴더에
        fingerprint.bmp라는 파일명으로 저장되게 되어있다.

        issue 지문 저장장소가 tmp폴더에 되어있는데 이것을 지금 위치의 폴더에 저장해야 할듯....
        '''
        if gender == 'm':
            gender = 'M'
        if gender == 'f':
            gender = 'F'
        imageDestination =  tempfile.gettempdir() + '/fingerprint.BMP'
        print(imageDestination)
        imageDestination = os.path.dirname(os.path.realpath(__file__))+"/"+path+"__"+gender+"_Right_index_finger.BMP"
        f.downloadImage(imageDestination)

        print('The image was saved to "' + imageDestination + '".')
        return "00"

    except Exception as e:
        print('Operation failed!')
        print('Exception message: ' + str(e))
        #exit(1)
        return "01"

parser = argparse.ArgumentParser(description='Process some integers.')
parser.add_argument('path', help='경로 입력')
parser.add_argument('gender', help='성별 입력')

args = parser.parse_args()
save_finger(args.path, args.gender)


