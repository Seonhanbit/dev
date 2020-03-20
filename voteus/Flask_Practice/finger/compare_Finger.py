'''

박종수 장인호

전처리 후 지문 이미지와 사람이름(코드)을 받아 두 개의 지문을 비교하여 일치률을 리턴하도록 하는 코드

'''
import cv2
import numpy as np
import pickle
import random

from keras.models import model_from_json

def compareFinger(name):

    # model과 model weight를 확인함
    json_file = open("finger/model.json", "r")
    loaded_model_json = json_file.read()
    json_file.close()
    model = model_from_json(loaded_model_json)
    model.load_weights("finger/model.h5")

    model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['acc'])

    # score = loaded_model.evaluate(X,Y,verbose=0)
    # model = Model(inputs=[x1, x2], outputs=net)

    # label.p 파일로 부터 객체 읽기

    with open('finger/label.p', 'rb') as file:
        #label_val = pickle.load(file)
        x_real = pickle.load(file)
        y_real = pickle.load(file)
        label_real_dict = pickle.load(file)


    #받은 코드와 일치하는 label을 y_real에서 찾음
    idx = 0
    print("label_val : ", len(y_real))
    for i in range(1, len(y_real)):
        print(y_real[i])
        if y_real[i][0] == name:
            idx = i
            break

    print(idx)
    print(y_real[idx])
    random_idx = idx

    #img를 불러오고, resize, 하고 random_label에 찾은 라벨을 넣음
    path = "finger/fingerprint.bmp"  # glob.glob("Real_temp/601__M_Left_1_2.bmp")
    print(path)
    random_img = cv2.imread(path, cv2.IMREAD_GRAYSCALE)
    print(random_img)
    img = cv2.resize(random_img, (96, 96))
    img_r = img[:, :, np.newaxis]
    random_label = y_real[random_idx]

    # random_img_iaa = seq.augment_image(img_r)#이거 굳이 안해도 됨
    random_img_r = img_r[np.newaxis]
    print(random_img_r.shape)
    random_img_rr = random_img_r.astype(np.float32) / 255.

    # matched image
    match_key = random_label.astype(str)
    match_key = ''.join(match_key).zfill(6)

    temp_match = x_real[label_real_dict[match_key]][np.newaxis]
    rx = temp_match.astype(np.float32) / 255.
    ry = y_real[label_real_dict[match_key]]

    #모델을 통해 이미지 예측
    pred_rx = model.predict([random_img_rr, rx])

    print('0: %.02f, %s' % (pred_rx, ry))
    return pred_rx
    if pred_rx > 0.75:
        return pred_rx



