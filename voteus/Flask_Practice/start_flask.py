from flask import Flask, request
import json
import face.examples.knn_ImageFile_TF as knn
import finger.compare_Finger as cf
from finger import example_downloadimage as ed
import base64
from flask_cors import CORS

app = Flask(__name__)
CORS(app)
'''
연습용 코드
'''

@app.route('/')
def hello_world():
    return 'Hello World!'

'''
박종수
라즈베리파이에서 지문센서에서 데이터를 받아 finger폴더에 fingerprint.bmp에 저장하고, base64로 img와 code를 전달
code
00 : 저장 성공
01 : 저장 실패
02 : 센서 인식 불가
03 : 시간 초과
04 : 예기치 못한 오류

'''
@app.route('/getFinger', methods=['post'])
def getFinger():
    try:
        # knn_ImageFile_TF에서 지문을 저장하고 코드를 받아온다.
        is_true = ed.get_finger()
        print(is_true)
        print(type(is_true))

        #저장 성공/실패시 data에 code와 img를 넣고 반환
        if is_true == "00":
            with open('finger/fingerprint.bmp', 'rb') as image:
                b64img = base64.b64encode(image.read())
            # print(b64img)

            print(type(b64img))
            # data = {"code": "05", "img": str(b64img)}

            data = json.dumps({"code": "00", "img": str(b64img)[2:-1]})
            # data = json.dumps(True)
        else:
            data = json.dumps({"code": is_true})
            # data = json.dumps (False)

        return data

    #알 수 없는 애러 발생시 03반환
    except Exception as e:
        print('Exception message: ' + str(e))
        data = json.dumps({"code": "04"})
        return data


'''
박종수 장인호
저장된 model.h, model.json, label.p에 저장된 모델을 불러와
name을 받고 fingerprint.bmp로 저장된 이미지를 모델의 이미지와 비교하여 code를 반환
code
00 : 일치
01 : 불일치
02 : 에러 발생
'''
@app.route('/compareFinger', methods = ['post'])
def compareFinger():
    try:
        #이름 코드를 받아온다.
        print(request.get_json())
        data = request.get_json(force=True)
        print("data", data)
        name = data['name']

        #이름 코드를 compareFinger에서 지문 비교하고 일치률을 받아옴
        arc = cf.compareFinger(name)
        print("arc", arc)

        #일치률이 80%이상이면 일치 아니면 불일치
        if arc >= 0.75:
            data = json.dumps({"code": "00"})
        else:
            data = json.dumps({"code": "01"})
        return data

    except Exception as e:
        print('Exception message: ' + str(e))
        data = json.dumps({"code": "03"})
        return data

'''
박종수
react로부터 base64 이미지 받아와
그 img를 디코딩하고,
디코딩한 이미지를 find.jpg로 저장한 후
knn에서 나온 사람코드와 비교하여 일치여부를 code로 return
code
00 : 일치
01 : 불일치
02 : 에러발생
03 : 얼굴 인식 불가(얼굴 0)
04 : 얼굴 인식 불가(얼굴 2개 이상)
'''
@app.route('/getImg', methods=['post'])
def getImg():
    print(1)
    try:
        # img와 코드를 저장
        data = request.get_json(force=True)
        print(data)
        name = data['name']
        print(name)
        img = data['img']

        # base를 디코딩하고 find.jpg로 저장
        file = base64.b64decode(str(img).split(',')[1])
        filename = 'find.jpg'
        with open(filename, 'wb') as f:
            f.write(file)
        print(2)
        file = open('find.jpg', 'r')

        # tmpname에 knn으로 부터 얻은 코드를 저장
        tmpname = knn.get_name(file)
        for predictname, (top, right, bottom, left) in tmpname:
            print(predictname)
            if int(predictname) == name:
                data = json.dumps({"code": "00"})
                return data
        #print('tmpname : ' + tmpname)

        # react로 받은 코드와 knn에서 나온 사람코드 값을 비교하여 일치여부를 json 파일로 저장 후 code에
        # if tmpname == name:
        #     data = json.dumps({"code": "00"})
        # else:
        #     data = json.dumps({"code": "01"})
        # data = json.dumps()
        data = json.dumps({"code": "01"})
        print(3)
        return data

    except Exception as e:
        print('Operation failed!')
        print('Exception message: ' + str(e))
        data = json.dumps({"code": "02"})
        return data



@app.route('/getJJ', methods=['post'])
def jj():
    data = json.dumps({"jun":"asdf"})
    return data


if __name__ == '__main__':
    app.run(host='0.0.0.0')