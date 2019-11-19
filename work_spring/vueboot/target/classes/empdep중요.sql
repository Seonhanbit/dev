src/main/resources/application.propertiees에서 mysql 환경만 수정해 주세요.

db schema ssafyhrm
username ssafy
password ssafy

src/main/resources/application   
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/ssafyhrm?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul
spring.datasource.username=ssafy
spring.datasource.password=ssafy


하다보니 오토인크리먼트가 아니어서 
자동증가를 하는 것 처럼 max+1해서 사용했습니다. id 나중에 자동증가로 바꿔서........

DROP TABLE s_emp;
DROP TABLE s_dept;
CREATE TABLE s_emp
(id                         DECIMAL(7)
   NOT NULL,
 name                  VARCHAR(25)
   NOT NULL,
 mailid                     VARCHAR(35),
 start_date                 DATE,
 manager_id                 DECIMAL(7),
 title                      VARCHAR(25),
 dept_id                    DECIMAL(7),
 salary                     DECIMAL(11, 2),
 commission_pct             DECIMAL(4, 2),
     CONSTRAINT PRIMARY KEY (id),
     CONSTRAINT UNIQUE (mailid),
     CONSTRAINT CHECK (commission_pct IN (10, 12.5, 15, 17.5, 20)));


CREATE TABLE s_dept
(dept_id                        DECIMAL(7)
    NOT NULL,
 name                       VARCHAR(25)
    NOT NULL,
 region_id                  DECIMAL(7),
     CONSTRAINT PRIMARY KEY (dept_id),
     CONSTRAINT UNIQUE (name, region_id));




INSERT INTO s_emp VALUES (
  1, '박구곤', 'sky98',
   str_to_date('03-MAR-1990','%d-%b-%Y'), NULL, '사장',
   118, 5000, NULL);
INSERT INTO s_emp VALUES (
   2, '손명성', '2xxsig',
   str_to_date('08-MAR-1990','%d-%b-%Y'), 1, '기획부장',
   110, 3000, NULL);
INSERT INTO s_emp VALUES (
   3, '이은선', 'ch21175',
   str_to_date('17-JUN-1991','%d-%b-%Y'), 1, '영업부장',
   102, 3500, NULL);
INSERT INTO s_emp VALUES (
   4, '서의홍', 'mquickto',
   str_to_date('07-APR-1990','%d-%b-%Y'), 1, '총무부장',
   101, 3000, NULL);
INSERT INTO s_emp VALUES (
   5, '김심선', 'aropebur',
   str_to_date('04-MAR-1990','%d-%b-%Y'), 1, '인사부장',
   118, 3200, NULL);
INSERT INTO s_emp VALUES (
   6, '전지영', 'murguhar',
   str_to_date('18-JAN-1991','%d-%b-%Y'), 2, '과장',
   110, 2400, NULL);
INSERT INTO s_emp VALUES (
   7, '김정미', 'enchu',
   str_to_date('14-MAY-1990','%d-%b-%Y'), 2, '과장',
   111, 2400, NULL);
INSERT INTO s_emp VALUES (
   8, '신기웅', 'bbiri',
   str_to_date('07-APR-1990','%d-%b-%Y'), 2, '과장',
   112, 2100, NULL);
INSERT INTO s_emp VALUES (
   9, '이상헌', 'acatchpo',
   str_to_date('09-FEB-1992','%d-%b-%Y'), 2, '과장',
   113, 2300, NULL);
INSERT INTO s_emp VALUES (
   10, '최순철', 'mhavel',
   str_to_date('27-FEB-1991','%d-%b-%Y'), 2, '과장',
   113, 2300, NULL);
INSERT INTO s_emp VALUES (
   11, '최정선', 'cmagee',
   str_to_date('14-MAY-1990','%d-%b-%Y'), 3, '영업대표이사',
   102, 2450, 10);
INSERT INTO s_emp VALUES (
   12, '안은경', 'hgiljum',
   str_to_date('18-JAN-1992','%d-%b-%Y'), 3, '영업대표이사',
   103, 2500, 12.5);
INSERT INTO s_emp VALUES (
   13, '김석우', 'ysedeghi',
   str_to_date('18-FEB-1991','%d-%b-%Y'), 3, '영업대표이사',
   104, 2650, 10);
INSERT INTO s_emp VALUES (
   14, '박성규', 'mnguyen',
   str_to_date('22-JAN-1992','%d-%b-%Y'), 3, '영업대표이사',
   105, 2650, 15);
INSERT INTO s_emp VALUES (
   15, '신종필', 'adumas',
   str_to_date('09-OCT-1991','%d-%b-%Y'), 3, '영업대표이사',
   106, 2400, 17.5);
INSERT INTO s_emp VALUES (
   16, '이기철', 'emaduro',
   str_to_date('07-FEB-1992','%d-%b-%Y'), 6, '사원',
   110, 2400, NULL);
INSERT INTO s_emp VALUES (
   17, '구원상', 'gsmith',
   str_to_date('08-MAR-1990','%d-%b-%Y'), 6, '사원',
   110, 940, NULL);
INSERT INTO s_emp VALUES (
   18, '서정주', 'anozaki',
   str_to_date('09-FEB-1991','%d-%b-%Y'), 7, '사원',
   111, 1200, NULL);
INSERT INTO s_emp VALUES (
   19, '안창환', 'vpatel',
   str_to_date('06-AUG-1991','%d-%b-%Y'), 7, '사원',
   111, 795, NULL);
INSERT INTO s_emp VALUES (
   20, '윤정숙', 'cnewman',
   str_to_date('21-JUL-1991','%d-%b-%Y'), 8, '사원',
   112, 750, NULL);
INSERT INTO s_emp VALUES (
   21, '장현철','amarkari',
   str_to_date('26-MAY-1991','%d-%b-%Y'), 8, '사원',
   112, 850, NULL);
INSERT INTO s_emp VALUES (
   22, '장혜숙', 'echang',
   str_to_date('30-NOV-1990','%d-%b-%Y'), 9, '사원',
   113, 800, NULL);
INSERT INTO s_emp VALUES (
   23, '강연범', 'rpatel',
   str_to_date('17-OCT-1990','%d-%b-%Y'), 9, '사원',
   106, 795, NULL);
INSERT INTO s_emp VALUES (
   24, '오은경', 'bdancs',
   str_to_date('17-MAR-1991','%d-%b-%Y'), 10, '사원',
   113, 860, NULL);
INSERT INTO s_emp VALUES (
   25, '이용호', 'sschwart',
   str_to_date('09-MAY-1991','%d-%b-%Y'), 10, '사원',
   113, 1100, NULL);

INSERT INTO s_dept VALUES (
   101, '총무부', 1);
INSERT INTO s_dept VALUES (
   102, '영업부', 1);
INSERT INTO s_dept VALUES (
   103, '영업부', 2);
INSERT INTO s_dept VALUES (
   104, '영업부', 3);
INSERT INTO s_dept VALUES (
   105, '영업부', 4);
INSERT INTO s_dept VALUES (
   106, '영업부', 5);
INSERT INTO s_dept VALUES (
   110, '기획부', 1);
INSERT INTO s_dept VALUES (
   111, '기획부', 2);
INSERT INTO s_dept VALUES (
   112, '기획부', 3);
INSERT INTO s_dept VALUES (
   113, '기획부', 4);
INSERT INTO s_dept VALUES (
   118, '인사부', 1);
INSERT INTO s_dept VALUES (
   120, '회계부', 5);
   
   
   
   
   
   