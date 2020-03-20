'''
지문 이미지를 alter 시켜 cnn 데이터에 추가하기 위한 코드
박종수
2020.02.10
rotate_Image(imgPath, x,y,d, r,desPath):
obliterate_Image(imgPath, x,y,d, r,desPath):

각 각 사각형 영역을 지정하고 그 영영을 회전시키거나,
가우시안 블러를 적용하여 흐릿하게 만들어 소실시키는 목적으로 만듬
'''

from PIL import Image
from PIL import ImageFilter

'''
이미지를 사각형으로 회전하기 메소드
imgPath : 이미지 경로
x,y 시작 위치
xx, yy 끝 위치
r 각도
desPath : 저장 경로
'''
def rotate_Image(imgPath, x,y, d, r,desPath):
    img = Image.open(imgPath)
    
    sub_image = img.crop(box=(x, y, x+d, y+d)).rotate(r)
    img.paste(sub_image, box=(x, y))
    
    img.save(desPath)
    
'''
이미지 소실을 위한 메소드
원형으로 가우시안 필터를 적용하여 흐릿하게 만든다
imgPath : 이미지 경로
x,y 시작 위치
xx, yy 끝 위치
desPath : 저장 경로
'''
def obliterate_Image(imgPath, x,y,d, desPath):
    img = Image.open(imgPath)
    gaussianBlur = ImageFilter.GaussianBlur(3)
    sub_image = img.crop(box=(x, y, x+d, y+d)).filter(gaussianBlur)
    #sub_image = img.filter(gaussianBlur)
    img.paste(sub_image, box=(x, y))
    img.save(desPath)
    
    
# obliterate_Image("601__M_Left_index_finger.bmp",
#                  43,43,
#                  53,53,
#                  5,
#                  "./obliterate.bmp")