// 리스트 4.4  Application 트레이트 사용

import ChecksumAccumulator.calculate

object FaillWinterSpringSummer extends Application {
  for (season <- List("fall", "winter", "spring"))
    println(season +": "+ calculate(season))
}
