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

'''
지문센서로 부터 지문 이미지를 얻어와 라즈베리파이에 fingerprint.bmp로 저장하는 코드
code
00 : 저장 성공
01 : 저장 실패
02 : 센서 인식 불가
03 : 시간 초과

최종 수정일 2020.02.05 09:32
박종수

'''
def get_finger():
    print('start files')
    try:
        '''
        usb port에 연결하여 지문센서 연결 여부를 확인
        센서가 연결이 되어있지 않을 시 code 02반환
        '''
        f = PyFingerprint('/dev/ttyUSB0', 57600, 0xFFFFFFFF, 0x00000000)
        print('get print')
        # if ( f.verifyPassword() == False ):
        #   raise ValueError('The given fingerprint sensor password is wrong!')

    except Exception as e:
        print('The fingerprint sensor could not be initialized!')
        print('Exception message: ' + str(e))
        #exit(1)
        return "02"

    ## Gets some sensor information
    # print('Currently used templates: ' + str(f.getTemplateCount()) +'/'+ str(f.getStorageCapacity()))

    #시간 측정을 위한 starttime
    startTime = time.time()
    print(startTime)
    ## Tries to read image and download it
    try:
        '''
        지문을 인식할 때 까지 대가하는 코드
        '''
        print('Waiting for finger...')


        #15초가 지날 시 code 03;
        while (f.readImage() == False):
            if time.time() - startTime > 15:
                return "03"
            pass

        print('Downloading image (this take a while)...')

        '''
        지문 센서로 부터 이미지를 얻어서 imageDestination에 저장하는 코드
        finger/fingerprint.bmp로 저장하고 성공시 00, 실패시 01
        '''
        imageDestination =  tempfile.gettempdir() + '/fingerprint.bmp'
        print(imageDestination)
        imageDestination = os.path.dirname(os.path.realpath(__file__))+'/fingerprint.bmp'
        f.downloadImage(imageDestination)

        print('The image was saved to "' + imageDestination + '".')
        return "00"

    except Exception as e:
        print('Operation failed!')
        print('Exception message: ' + str(e))
        #exit(1)
        return "01"


