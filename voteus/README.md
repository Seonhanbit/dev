# VoteUS

## 0. 개요

* Raspberry Pi를 통해 얼굴/지문 인증 후 전자투표하는 모바일 웹 프로젝트
* 비용과 인력을 줄이고, 효율성을 제고하고자 기획
* 얼굴 : KNN 알고리즘 이용
* 지문 : CNN 알고리즘 이용
* SpringBoot와 React를 이용한 관리자 페이지 구성
* Flask 템플릿에서 Python과 React를 이용한 사용자 페이지 구성

**파일 정보**
* Flask_practice : 지문/얼굴 인증 
* project01 : rest api(spring boot)
* react : admin frontend 페이지
* React_User : user frontend 페이지

## 1. 개발 환경

**Language**
* Java, Python

**Hardware**
* Raspberry Pi
* Kiosk
* Camera Module
* Finger Print Sensor

**Library**
* TensorFlow
* React

**Framework**
* Spring Boot
* Flask
* Material UI
* Spring security

**Database**
* MariaDB

## 2. 개발 계획

* 진행 기간 : 2020.01 ~ 2020.03

## 3. DB 모델링

* ![image](./DB.JPG)


## 4. 핵심 기능

### 1) 얼굴 인증

* KNN 알고리즘 이용()
* 사용자 등록 후 70%이상 일치 시 True/False

### 2) 지문 인증

* CNN 알고리즘 이용(합성곱 신경망)

### 3) 관리자 페이지

* Spring Boot로 RestAPI 구현
* admin 계정 로그인 기능 구현
* 투표자 등록/수정/삭제/조회 기능
* 투표 등록/수정/삭제/조회 기능
* 후보자 등록/수정/삭제/조회 기능
* 지역 등록/수정/삭제/조회 기능
* 정당 등록/수정/삭제/조회 기능

### 4) 사용자 페이지

* Spring Boot로 RestAPI 구현

## 5. 스크린 샷
**사용자 페이지**

![image](./userpage.JPG)

**관리자 페이지**

![image](./adminpage.png)

## 6. 느낀 점

* AWS 서비스 론칭을 통한 실무적인 영역에서 웹 서비스 퍼블리싱 감각 터득 
