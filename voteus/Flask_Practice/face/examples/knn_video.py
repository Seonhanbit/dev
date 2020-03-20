"""
This is an example of using the k-nearest-neighbors (KNN) algorithm for face recognition.

When should I use this example?
This example is useful when you wish to recognize a large set of known people,
and make a prediction for an unknown person in a feasible computation time.

Algorithm Description:
The knn classifier is first trained on a set of labeled (known) faces and can then predict the person
in an unknown image by finding the k most similar faces (images with closet face-features under eucledian distance)
in its training set, and performing a majority vote (possibly weighted) on their label.

For example, if k=3, and the three closest face images to the given image in the training set are one image of Biden
and two images of Obama, The result would be 'Obama'.

* This implementation uses a weighted vote, such that the votes of closer-neighbors are weighted more heavily.

Usage:

1. Prepare a set of images of the known people you want to recognize. Organize the images in a single directory
   with a sub-directory for each known person.

2. Then, call the 'train' function with the appropriate parameters. Make sure to pass in the 'model_save_path' if you
   want to save the model to disk so you can re-use the model without having to re-train it.

3. Call 'predict' and pass in your trained model to recognize the people in an unknown image.

NOTE: This example requires scikit-learn to be installed! You can install it with pip:

$ pip3 install scikit-learn

"""

import math
from sklearn import neighbors
import numpy as np
import cv2
import os
import os.path
import pickle
from PIL import Image, ImageDraw
import face_recognition
#from face_recognition.face_recognition_cli import image_files_in_folder

ALLOWED_EXTENSIONS = {'png', 'jpg', 'jpeg', 'jfif'}

video_capture = cv2.VideoCapture(0)
ret, frame = video_capture.read()
X_img = frame[:, :, ::-1] #np.array(frame)
ans = 0

def predict(knn_clf=None, model_path=None, distance_threshold=0.6):
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
    if knn_clf is None:
        with open(model_path, 'rb') as f:
            knn_clf = pickle.load(f)

    # Grab a single frame of video
    #ret, frame = X_img_path.read()

    # Load image file and find face locations
    # X_img = frame[:, :, ::-1] #np.array(frame)
    # print("X_img")
    # print(X_img)
    #X_img = face_recognition.load_image_file(frame)
    X_face_locations = face_recognition.face_locations(X_img)
    print(len(X_face_locations))
    #cv2.imshow("asdf", X_face_locations)
    # If no faces are found in the image, return an empty result.
    if len(X_face_locations) == 0:
        return []

    # Find encodings for faces in the test iamge
    # print(rgb_small_frame)
    print("X_face_locations")
    print(X_face_locations)

    # cap = cv2.VideoCapture(0)
    # ret1, frame1 = cap.read()

    # while True:
    #
    #     if ret:
    #         cv2.imshow("video", X_img)
    #
    #         if cv2.waitKey(1) & 0xFF == ord('q'):
    #             break;
    #     else:
    #         break;
    print(X_face_locations)

    faces_encodings = face_recognition.face_encodings(X_img, known_face_locations=X_face_locations)
    print(faces_encodings)
    # Use the KNN model to find the best matches for the test face
    closest_distances = knn_clf.kneighbors(faces_encodings, n_neighbors=1)
    #closest_distances = knn_clf.kneighbors(faces_encodings, n_neighbors=1)
    are_matches = [closest_distances[0][i][0] <= distance_threshold for i in range(len(X_face_locations))]

    # Predict classes and remove classifications that aren't within the threshold
    return [(pred, loc) if rec else ("unknown", loc) for pred, loc, rec in zip(knn_clf.predict(faces_encodings), X_face_locations, are_matches)]


def show_prediction_labels_on_image(predictions):
    global ans
    """
    Shows the face recognition results visually.

    :param img_path: path to image to be recognized
    :param predictions: results of the predict function
    :return:
    """
    #pil_image = Image.open(img_path).convert("RGB")
    #draw = ImageDraw.Draw(pil_image)

    for name, (top, right, bottom, left) in predictions:
        # Draw a box around the face using the Pillow module
        #draw.rectangle(((left, top), (right, bottom)), outline=(0, 0, 255))
        cv2.rectangle(frame, (left, top), (right, bottom), (0,0,255))
        cv2.rectangle(frame, (left, bottom - 35), (right, bottom), (0, 0, 255), cv2.FILLED)
        # There's a bug in Pillow where it blows up with non-UTF-8 text
        # when using the default bitmap font
        print(name)
        #name = name.encode("UTF-8")
        print(name)
        font = cv2.FONT_HERSHEY_DUPLEX
        cv2.putText(frame, name, (left + 6, bottom - 6), font, 1.0, (255, 255, 255), 1)
        if name == "jsp":
            ans += 1
        # Draw a label with a name below the face
        # text_width, text_height = draw.textsize(name)
        # draw.rectangle(((left, bottom - text_height - 10), (right, bottom)), fill=(0, 0, 255), outline=(0, 0, 255))
        # draw.text((left + 6, bottom - text_height - 5), name, fill=(255, 255, 255, 255))

    # Remove the drawing library from memory as per the Pillow docs
    #del draw
    #cv2.imshow("file", X_img)
    # Display the resulting image
    # pil_image.show()
    

if __name__ == "__main__":
    # STEP 1: Train the KNN classifier and save it to disk
    # Once the model is trained and saved, you can skip this step next time.
    #video_capture = cv2.VideoCapture(0)
    cnt = 0
    ans = 0
    while True:
        if cnt>10:
            break;
        ret, frame = video_capture.read()


        X_img = frame[:, :, ::-1]  # np.array(frame)
        predictions = predict(model_path="trained_knn_model.clf")
        show_prediction_labels_on_image(predictions)
        cv2.imshow("video", frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break;
        cnt+=1
        
        

    if ans>5:
        print("맞")
    else:
        print("아니")
    video_capture.release()
    cv2.destroyAllWindows()



