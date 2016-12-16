// 리스트 22.3  List 클래스의 ::(콘즈) 메소드 정의

def ::[U >: T](x: U): List[U] = new scala.::(x, this)
