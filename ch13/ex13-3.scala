// 리스트 13.3  한 파일 안에 여러 패키지 넣기

package bobsrockets {
  package navigation {

    // bobsrockets.navigation 패키지 안쪽
    class Navigator

    package tests {

      // bobsrockets.navigation.tests 패키지 안쪽
      class NavigatorSuite
    }
  }
}
