<<<<<<< HEAD
��          �               <  s   =  k   �  T    �   r  V   :  �   �  P   s  s   �  T   8  X  �  :   �  1   !	  �   S	      :
  �   [
  �   S  9   �  [    s   {  k   �  T  [  �   �  V   x  �   �  P   �  s     T   v  X  �  :   $  1   _  �   �      x  �   �  �   �  9   #   5-1. CSV 파일 DataStore을 만들어 보자. 우선 Open csv file을 클릭하고, 예제 데이터를 열어라. 5-2 이번에는 PostGIS DataStore를 만들어 보자. 우선 Connect to PostGIS database를 클릭한다. 6-1. CSV DataStore를 생성하는 데 필요한 설정은 다음과 같다. strategy는 기하가 파일에 어떻게 표현되어 있는지를 나타낸다. 만약 파일이 wkt(well known text)형식의 칼럼을 가지고 있어 기하를 해당 칼럼에 저장하고 있다면, strategy에 'wkt'라고 입력하라. 만약 파일이 WGS84좌표의 포인트를 두 개의 칼럼으로 각각 lattitude와 longitude를 저장하고 있다면, strategy에 'latlng'라고 입력하라. 만약 파일이 기하를 가지고 있지 않다면, 당신은 strategy를 입력하지 않아도 된다. 6-2 PostGIS DataStore를 생성하는 데 필요한 설정은 다음과 같다. 비밀번호 이후 설정은 옵션이므로 나머지는 입력하지 않고, finish버튼을 눌러도 무방하다. 7-1. DataStore에 있는 데이터를 보고싶다면, getfeature 버튼을 눌러라. 7-2 Insert Solid to PostGIS database버튼을 누르면 PostGIS 데이터베이스에 oneSolid라는 이름으로 id와 geometry를 칼럼으로 가지는 테이블이 하나 생기고, Solid 데이터 하나가 들어간다. CSV DataStore로부터 getfeature함수를 적용한 결과는 다음과 같다. GeoTools-3d-extention을 사용하기 위해서 pom.xml파일에 다음을 참고하여 dependency를 추가하라. PostGIS DataStore로부터 getfeature함수를 적용한 결과는 다음과 같다. dropdownlist에는 연결된 데이터베이스의 테이블들을 볼 수 있다. insert버튼을 누른 후에 새로 생성된 oneSolid테이블이 dropdownlist에 나타난 것을 확인할 수 있다. 해당 테이블의 데이터를 보기 위해서 dropdownlist에서 oneSolid테이블이 선택된 채로 getfeature 버튼을 누른다. insert의 결과를 다음과 같이 확인할 수 있다. 다음의 코드를 프로젝트에 추가하라. 만약 당신이 wkt를 입력하였다면, wkt형식의 칼럼 이름을 wktField에 입력하라. 만약 당신이 latlng을 입력하였다면, lattitude, longitude 칼럼의 이름을 각각 latField, lngField에 입력하라. 빠르게 시작하는 메뉴얼 빠르게 시작하는 메뉴얼은 3차원 지리공간을 처음 접하는 자바 개발자를 대상으로 설명한다. 자바와 이클립스 설치 및 프로젝트 생성은 GeoTools 페이지를 참고하라 `GeoTools Eclipse Quickstart`_. 위의 어플리케이션을 실행하면 당신은 CSV 파일을 열거나 PostGIS에 연결함으로써 3차원 DataStore을 만들 수 있다. 프로젝트를 생성한 후 pom.xml파일을 열어라. Project-Id-Version: geotools-3d-extension 2.7.1
Report-Msgid-Bugs-To: 
POT-Creation-Date: 2017-08-28 14:05+0900
PO-Revision-Date: YEAR-MO-DA HO:MI+ZONE
Last-Translator: FULL NAME <EMAIL@ADDRESS>
Language-Team: LANGUAGE <LL@li.org>
MIME-Version: 1.0
Content-Type: text/plain; charset=utf-8
Content-Transfer-Encoding: 8bit
Generated-By: Babel 2.4.0
 5-1. CSV 파일 DataStore을 만들어 보자. 우선 Open csv file을 클릭하고, 예제 데이터를 열어라. 5-2 이번에는 PostGIS DataStore를 만들어 보자. 우선 Connect to PostGIS database를 클릭한다. 6-1. CSV DataStore를 생성하는 데 필요한 설정은 다음과 같다. strategy는 기하가 파일에 어떻게 표현되어 있는지를 나타낸다. 만약 파일이 wkt(well known text)형식의 칼럼을 가지고 있어 기하를 해당 칼럼에 저장하고 있다면, strategy에 'wkt'라고 입력하라. 만약 파일이 WGS84좌표의 포인트를 두 개의 칼럼으로 각각 lattitude와 longitude를 저장하고 있다면, strategy에 'latlng'라고 입력하라. 만약 파일이 기하를 가지고 있지 않다면, 당신은 strategy를 입력하지 않아도 된다. 6-2 PostGIS DataStore를 생성하는 데 필요한 설정은 다음과 같다. 비밀번호 이후 설정은 옵션이므로 나머지는 입력하지 않고, finish버튼을 눌러도 무방하다. 7-1. DataStore에 있는 데이터를 보고싶다면, getfeature 버튼을 눌러라. 7-2 Insert Solid to PostGIS database버튼을 누르면 PostGIS 데이터베이스에 oneSolid라는 이름으로 id와 geometry를 칼럼으로 가지는 테이블이 하나 생기고, Solid 데이터 하나가 들어간다. CSV DataStore로부터 getfeature함수를 적용한 결과는 다음과 같다. GeoTools-3d-extention을 사용하기 위해서 pom.xml파일에 다음을 참고하여 dependency를 추가하라. PostGIS DataStore로부터 getfeature함수를 적용한 결과는 다음과 같다. dropdownlist에는 연결된 데이터베이스의 테이블들을 볼 수 있다. insert버튼을 누른 후에 새로 생성된 oneSolid테이블이 dropdownlist에 나타난 것을 확인할 수 있다. 해당 테이블의 데이터를 보기 위해서 dropdownlist에서 oneSolid테이블이 선택된 채로 getfeature 버튼을 누른다. insert의 결과를 다음과 같이 확인할 수 있다. 다음의 코드를 프로젝트에 추가하라. 만약 당신이 wkt를 입력하였다면, wkt형식의 칼럼 이름을 wktField에 입력하라. 만약 당신이 latlng을 입력하였다면, lattitude, longitude 칼럼의 이름을 각각 latField, lngField에 입력하라. 빠르게 시작하는 메뉴얼 빠르게 시작하는 메뉴얼은 3차원 지리공간을 처음 접하는 자바 개발자를 대상으로 설명한다. 자바와 이클립스 설치 및 프로젝트 생성은 GeoTools 페이지를 참고하라 `GeoTools Eclipse Quickstart`_. 위의 어플리케이션을 실행하면 당신은 CSV 파일을 열거나 PostGIS에 연결함으로써 3차원 DataStore을 만들 수 있다. 프로젝트를 생성한 후 pom.xml파일을 열어라. 
=======
��          T               �   s   �   s        u  �   �  �   p  9     [  <  s   �  s         �  �   �  �   �  9      6-1. CSV 파일 DataStore을 만들어 보자. 우선 Open csv file을 클릭하고, 예제 데이터를 열어라. GeoTools-3d-extention을 사용하기 위해서 pom.xml파일에 다음을 참고하여 dependency를 추가하라. Quickstart Manual Quickstart Manual는 3차원 지리공간을 처음 접하는 자바 개발자를 대상으로 설명한다. 자바와 이클립스 설치 및 프로젝트 생성은 GeoTools 페이지를 참고하라 `GeoTools Eclipse Quickstart`_. 위의 어플리케이션을 실행하면 당신은 CSV 파일을 열거나 PostGIS에 연결함으로써 3차원 DataStore을 만들 수 있다. 프로젝트를 생성한 후 pom.xml파일을 열어라. Project-Id-Version: geotools-3d-extension 2.7.1
Report-Msgid-Bugs-To: 
POT-Creation-Date: 2017-08-24 12:59+0900
PO-Revision-Date: YEAR-MO-DA HO:MI+ZONE
Last-Translator: FULL NAME <EMAIL@ADDRESS>
Language-Team: LANGUAGE <LL@li.org>
MIME-Version: 1.0
Content-Type: text/plain; charset=utf-8
Content-Transfer-Encoding: 8bit
Generated-By: Babel 2.4.0
 6-1. CSV 파일 DataStore을 만들어 보자. 우선 Open csv file을 클릭하고, 예제 데이터를 열어라. GeoTools-3d-extention을 사용하기 위해서 pom.xml파일에 다음을 참고하여 dependency를 추가하라. 빠르게 시작하는 메뉴얼 Quickstart Manual는 3차원 지리공간을 처음 접하는 자바 개발자를 대상으로 설명한다. 자바와 이클립스 설치 및 프로젝트 생성은 GeoTools 페이지를 참고하라 `GeoTools Eclipse Quickstart`_. 위의 어플리케이션을 실행하면 당신은 CSV 파일을 열거나 PostGIS에 연결함으로써 3차원 DataStore을 만들 수 있다. 프로젝트를 생성한 후 pom.xml파일을 열어라. 
>>>>>>> branch 'master' of https://github.com/STEMLab/geotools-3d-extension
