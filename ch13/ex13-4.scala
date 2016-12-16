// 리스트 13.4  클래스와 패키지에 간결하게 접근하기

package bobsrockets {
  package navigation {
    class Navigator {
      // bobsrockets.navigation.StarMap을 쓸 필요가 없다.
      val map = new StarMap
    }
    class StarMap

    class Ship {
      // bobsrockets.navigation.Navigator를 쓸 필요가 없다.
      val nav = new navigation.Navigator
    }

    package fleets {
      class Fleet {
        // bobsrockets.Ship을 쓸 필요가 없다.
        def addShip() { new Ship }
      }
    }
  }
}
