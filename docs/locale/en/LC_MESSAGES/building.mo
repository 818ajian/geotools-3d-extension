��          �               |     }     �  @   �     �     �  7        H     N     S     Y     ]     b  �   i  .   +  T  Z  W   �       4    �   C     �  �   �  [  �     7	     C	  @   `	     �	     �	  7   �	     
     
     
     
     
     
  �   #
  (   �
  !  �
  F   
     Q  �   Z  ^   5     �  �   �   $ cd ../../ $ cd unsupported/geometry-ng $ git clone https://github.com/STEMLab/geotools-3d-extension.git $ mvn clean install $ sudo ./cppbuild.sh $ sudo apt-get install -y cmake libgmp3-dev libmpfr-dev Boost CGAL CMAKE GMP MPFR SFCGAL SFCGAL, CGAL, Boost 라이브러리에서 필요한 라이브러리들을 설치합니다. 이미 이 라이브러리들이 설치되어 있다면 다음의 과정은 생략해도 좋습니다. Ubuntu 16.04에서 GeoTools 3D를 설치하기 gt-geometry-ng 모듈 내의 cppbuild.sh 파일을 실행하면 SFCGAL, CGAL, Boost 라이브러리가 시스템에 자동으로 설치됩니다. 시스템에 해당 라이브러리들을 설치하기 위하여 gt-geometry-ng 모듈의 경로로 이동한 후 sudo 권한 요청과 함께 cppbuild.sh를 다음과 같이 실행하십시오. 먼저 다음의 명령어로 Git Repository로 부터 프로젝트를 받아옵니다. 빌드 이 장에서는 이 프로젝트를 빌드하기 위한 방법을 소개합니다. 이 프로젝트가 사용하는 몇 가지 라이브러리가 c++ 언어 기반이기 때문에 이 프로젝트를 빌드하기 이전에 필요 라이브러리들을 우선적으로 설치하는 과정이 필요합니다. 이제 다음과 같이 루트 경로로 돌아가서 전체 프로젝트를 빌드하여 빌드가 성공함을 확인하십시오. 필요 라이브러리 필요 라이브러리가 모두 제대로 설치되었는지 확인하기 위해 gt-geometry-ng 모듈을 다음과 같이 빌드합니다. 모든 빌드가 완료된 후 수행되는 모든 테스트가 성공하면 설치가 완료된 것입니다. Project-Id-Version: geotools-3d-extension 2.7.1
Report-Msgid-Bugs-To: 
POT-Creation-Date: 2017-08-28 10:27-0400
PO-Revision-Date: YEAR-MO-DA HO:MI+ZONE
Last-Translator: FULL NAME <EMAIL@ADDRESS>
Language-Team: LANGUAGE <LL@li.org>
MIME-Version: 1.0
Content-Type: text/plain; charset=utf-8
Content-Transfer-Encoding: 8bit
Generated-By: Babel 2.4.0