'''

박종수 장인호
전처리를 위한 코드

'''

import cv2
import matplotlib.pyplot as plt
import numpy as np
from glob import glob
import os
import finger.alter_Image as al
import random
# image 경로로부터 label을 뽑아 옴
def extract_label(img_path):
    filename, _ = os.path.splitext(os.path.basename(img_path))
    #print(filename)
    subject_id, etc = filename.split('__')
    gender, lr, finger, _ = etc.split('_')

    gender = 0 if gender == 'M' else 1
    lr = 0 if lr == 'Left' else 1

    if finger == 'thumb':
        finger = 0
    elif finger == 'index':
        finger = 1
    elif finger == 'middle':
        finger = 2
    elif finger == 'ring':
        finger = 3
    elif finger == 'little':
        finger = 4

    if 600 <= int(subject_id):
        print(filename)
        rannumx = random.randint(-10, 10)
        rannumy = random.randint(-10, 10)
        randomr = random.randint(30, 50)
        #print("finger/Altered/Altered-Easy/"+filename+"_CR.BMP")
        al.rotate_Image(img_path, 48+rannumx, 48+rannumy, 10, randomr, "Altered/Altered-Easy/"+filename+"_CR.BMP")
        rannumx = random.randint(-10, 10)
        rannumy = random.randint(-10, 10)
        randomr = random.randint(60, 80)
        al.rotate_Image(img_path, 48 + rannumx, 48 + rannumy, 20, randomr, "Altered/Altered-Medium/"+filename+"_CR.BMP")
        rannumx = random.randint(-10, 10)
        rannumy = random.randint(-10, 10)
        randomr = random.randint(90, 120)
        al.rotate_Image(img_path, 48 + rannumx, 48 + rannumy, 30, randomr, "Altered/Altered-Hard/"+filename+"_CR.BMP")


        rannumx = random.randint(-10, 10)
        rannumy = random.randint(-10, 10)
        al.obliterate_Image(img_path, 48 + rannumx, 48 + rannumy, 10, "Altered/Altered-Easy/"+filename+"_Obi.BMP")
        rannumx = random.randint(-10, 10)
        rannumy = random.randint(-10, 10)
        al.obliterate_Image(img_path, 48 + rannumx, 48 + rannumy, 20, "Altered/Altered-Medium/"+filename+"_Obi.BMP")

        rannumx = random.randint(-10, 10)
        rannumy = random.randint(-10, 10)
        al.obliterate_Image(img_path, 48 + rannumx, 48 + rannumy, 40, "Altered/Altered-Hard/"+filename+"_Obi.BMP")



    return np.array([subject_id, gender, lr, finger], dtype=np.uint16)


def extract_label2(img_path):
    filename, _ = os.path.splitext(os.path.basename(img_path))

    subject_id, etc = filename.split('__')
    gender, lr, finger, _, _ = etc.split('_')

    gender = 0 if gender == 'M' else 1
    lr = 0 if lr == 'Left' else 1

    if finger == 'thumb':
        finger = 0
    elif finger == 'index':
        finger = 1
    elif finger == 'middle':
        finger = 2
    elif finger == 'ring':
        finger = 3
    elif finger == 'little':
        finger = 4

    return np.array([subject_id, gender, lr, finger], dtype=np.uint16)




img_list = sorted(glob('Real/*.BMP'))
print(len(img_list))
imgs = np.empty((len(img_list), 96, 96, 1), dtype=np.uint8)
labels = np.empty((len(img_list), 4), dtype=np.uint16)

for i, img_path in enumerate(img_list):
    img = cv2.imread(img_path, cv2.IMREAD_GRAYSCALE)
    img = cv2.resize(img, (96, 96))
    img_r = img[:, :, np.newaxis]
    imgs[i] = img_r

    # subject_id, gender, lr, finger
    labels[i] = extract_label(img_path)
    #600이 넘는 파일은 alter_Image에서 이미지 변환을 준다



#print(imgs[-441].shape)
np.savez('dataset/x_real.npz', data=imgs)
np.save('dataset/y_real.npy', labels)
#plt.figure(figsize=(1, 1))
#plt.title(labels[-441])
#plt.imshow(imgs[-441], cmap='gray')





img_list = sorted(glob('Altered/Altered-Easy/*.BMP'))
print(len(img_list))
imgs = np.empty((len(img_list), 96, 96, 1), dtype=np.uint8)
labels = np.empty((len(img_list), 4), dtype=np.uint16)
for i, img_path in enumerate(img_list):
    img = cv2.imread(img_path, cv2.IMREAD_GRAYSCALE)
    img = cv2.resize(img, (96, 96))
    img_r = img[:, :, np.newaxis]
    imgs[i] = img_r

    # subject_id, gender, lr, finger
    labels[i] = extract_label2(img_path)



np.savez('dataset/x_easy.npz', data=imgs)
np.save('dataset/y_easy.npy', labels)
# plt.figure(figsize=(1, 1))
# plt.title(labels[-1])
# plt.imshow(imgs[-1], cmap='gray')


img_list = sorted(glob('Altered/Altered-Medium/*.BMP'))
print(len(img_list))
imgs = np.empty((len(img_list), 96, 96, 1), dtype=np.uint8)
labels = np.empty((len(img_list), 4), dtype=np.uint16)
for i, img_path in enumerate(img_list):
    img = cv2.imread(img_path, cv2.IMREAD_GRAYSCALE)
    img = cv2.resize(img, (96, 96))
    img_r = img[:, :, np.newaxis]
    imgs[i] = img_r

    # subject_id, gender, lr, finger
    labels[i] = extract_label2(img_path)

np.savez('dataset/x_medium.npz', data=imgs)
np.save('dataset/y_medium.npy', labels)
# plt.figure(figsize=(1, 1))
# plt.title(labels[-1])
# plt.imshow(imgs[-1], cmap='gray')



img_list = sorted(glob('Altered/Altered-Hard/*.BMP'))
print(len(img_list))
imgs = np.empty((len(img_list), 96, 96, 1), dtype=np.uint8)
labels = np.empty((len(img_list), 4), dtype=np.uint16)
for i, img_path in enumerate(img_list):
    img = cv2.imread(img_path, cv2.IMREAD_GRAYSCALE)
    img = cv2.resize(img, (96, 96))
    img_r = img[:, :, np.newaxis]
    imgs[i] = img_r

    # subject_id, gender, lr, finger
    labels[i] = extract_label2(img_path)

np.savez('dataset/x_hard.npz', data=imgs)
#print(imgs)
np.save('dataset/y_hard.npy', labels)
# plt.figure(figsize=(1, 1))
# plt.title(labels[-1])
# plt.imshow(imgs[-1], cmap='gray')