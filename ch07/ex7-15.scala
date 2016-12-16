// 리스트 7.15  값을 만들어내는 match 표현식

val firstArg = if (args.length > 0) args(0) else ""

val friend =
  firstArg match {
    case "salt" => "pepper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }

println(friend)

