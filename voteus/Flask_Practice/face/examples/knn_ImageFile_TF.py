'''
박종수
image file을 받고 img를 누구인지를 판별한 후 그사람의 이름을 출력해주는 함수
'''

import numpy as np
import cv2
import time
#import face.examples.face_detection as fd
import pickle
import face_recognition

# from face_recognition.face_recognition_cli import image_files_in_folder

ALLOWED_EXTENSIONS = {'png', 'jpg', 'jpeg', 'jfif'}

#video_capture = cv2.VideoCapture(0)
#ret, frame = video_capture.read()
#X_img; #= frame[:, :, ::-1]  # np.array(frame)
ans = 0

'''
img를 읽어 face_locations와 face_encoding을 한 후 knn모델에서 얼굴을 분류하여 가장 일치율이 높은 얼굴을 반환하는 코드
'''
def predict(X_img, knn_clf=None, model_path=None, distance_threshold=0.6):
    """
    Recognizes faces in given image using a trained KNN classifier

    :param X_img_path: path to image to be recognized
    :param knn_clf: (optional) a knn classifier object. if not specified, model_save_path must be specified.
    :param model_path: (optional) path to a pickled knn classifier. if not specified, model_save_path must be knn_clf.
    :param distance_threshold: (optional) distance threshold for face classification. the larger it is, the more chance
           of mis-classifying an unknown person as a known one.
    :return: a list of names and face locations for the recognized faces in the image: [(name, bounding box), ...].
        For faces of unrecognized persons, the name 'unknown' will be returned.
    """
    # if not os.path.isfile(X_img_path) or os.path.splitext(X_img_path)[1][1:] not in ALLOWED_EXTENSIONS:
    #     raise Exception("Invalid image path: {}".format(X_img_path))
    #
    # if knn_clf is None and model_path is None:
    #     raise Exception("Must supply knn classifier either thourgh knn_clf or model_path")
    #
    # # Load a trained KNN model (if one was passed in)
    
    #knn_clf가 없을 시 model_path에서 모델을 읽어오는 코드
    print(model_path)
    if knn_clf is None:
        with open(model_path, 'rb') as f:
            print(f)
            print("before open")
            knn_clf = pickle.load(f)
            print("is_open?")

    # Grab a single frame of video
    # ret, frame = X_img_path.read()

    # Load image file and find face locations
    # X_img = frame[:, :, ::-1] #np.array(frame)
    
    #find.jpg에서 이미지를 읽음
    # print(X_img)
    startTime = time.time()

    X_img = face_recognition.load_image_file('find.jpg')
    print("face_recognition : load img")
    print(time.time() - startTime)

    #face_recognition에서 face_locations를 통해 얼굴의 위치를 찾음
    startTime = time.time()
    X_face_locations = face_recognition.face_locations(X_img)

    #print(X_face_locations)
    print(time.time() - startTime)

    #cv_image를 face_locations로 바꾼 것을 numarry로 변환
    startTime = time.time()
    # cv_image = np.array(X_face_locations)
    # cv_image = cv_image[:,:,::-1].copy()
    # X_face_locations = [(0, cv_image.shape[0], cv_image.shape[1], 0)]

    #그 후 face_encoding을 통해 128차원으로 얼굴 피러를 사전화...
    faces_encodings = face_recognition.face_encodings(X_img, known_face_locations=X_face_locations)
    #faces_encodings = [(0,cv_image.shape[0],cv_image.shape[1],0)]
    print("encoding")
    print(time.time() - startTime)

    #knn 모델을 통해 threshold 이하의 얼굴 특징을 찾아 넣음
    startTime = time.time()
    # Use the KNN model to find the best matches for the test face
    closest_distances = knn_clf.kneighbors(faces_encodings, n_neighbors=1)
    print("kneighbors")
    print(time.time() - startTime)
    # closest_distances = knn_clf.kneighbors(faces_encodings, n_neighbors=1)
    a = (1)
    #are_matches = [closest_distances[0][0][0] <= distance_threshold]
    are_matches = [closest_distances[0][i][0] <= distance_threshold for i in range(len(X_face_locations))]

    # Predict classes and remove classifications that aren't within the threshold
    return [(pred, loc) if rec else ("unknown", loc) for pred, loc, rec in
            zip(knn_clf.predict(faces_encodings), X_face_locations, are_matches)]



def get_name(img):
    #cv2.imshow(img)
    #print("이미지")
    X_img = img;
    #print("예측 전 디버그")

    #img2 = cv2.imread(img, cv2.IMREAD_COLOR)
    #cv2.imshow("asdf",img)
    #return predict(X_img, model_path="examples/trained_knn_model.clf")
    return predict(X_img, model_path="face/examples/trained_knn_model.clf")
    # for i in predictions:
    #     print(i)
    # return show_prediction_labels_on_image(predictions)

#


