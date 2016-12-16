// 28장 XML 다루기

// 28.3 XML 리터럴

<a>
  This is some XML.
  Here is a tag: <atag/>
</a>

<a> {"hello"+", world"} </a>

val yearMade = 1955
<a> { if (yearMade < 2000) <old>{yearMade}</old> else xml.NodeSeq.Empty }
</a>

<a> {3 + 4} </a>

<a> {"</a>potential security hole<a>"} </a>

"<a>" + "</a>potential security hole<a>" + "</a>"


// 28.4 직렬화

abstract class CCTherm {
  val description: String
  val yearMade: Int
  val dateObtained: String
  val bookPrice: Int           // 단위: 미국 센트
  val purchasePrice: Int       // 단위: 미국 센트
  val condition: Int           // 1부터 10까지

  override def toString = description

  def toXML =
    <cctherm>
      <description>{description}</description>
      <yearMade>{yearMade}</yearMade>
      <dateObtained>{dateObtained}</dateObtained>
      <bookPrice>{bookPrice}</bookPrice>
      <purchasePrice>{purchasePrice}</purchasePrice>
      <condition>{condition}</condition>
    </cctherm>
}

val therm = new CCTherm {
  val description = "hot dog #5"
  val yearMade = 1952
  val dateObtained = "March 14, 2006"
  val bookPrice = 2199
  val purchasePrice = 500
  val condition = 9
}
therm.toXML

<a> {{{{brace yourself!}}}} </a>


// 28.5 XML 분석

// 텍스트 추출

<a>Sounds <tag/> good</a>.text
<a> input ---&gt; output </a>.text


// 하위 엘리먼트 추출

<a><b><c>hello</c></b></a> \ "b"
<a><b><c>hello</c></b></a> \ "c"
<a><b><c>hello</c></b></a> \\ "c"
<a><b><c>hello</c></b></a> \ "a"
<a><b><c>hello</c></b></a> \\ "a"


// 애트리뷰트 추출

val joe = <employee
  name="Joe"
  nk="code monkey"
  serial="123"/>
joe \ "@name"
joe \ "@serial"


// 28.6 역 직렬화

def fromXML(node: scala.xml.Node): CCTherm =
  new CCTherm {
    val description     = (node \ "description").text
    val yearMade        = (node \ "yearMade").text.toInt
    val dateObtained    = (node \ "dateObtained").text
    val bookPrice       = (node \ "bookPrice").text.toInt
    val purchasePrice   = (node \ "purchasePrice").text.toInt
    val condition       = (node \ "condition").text.toInt
  }

val node = therm.toXML
fromXML(node)


// 28.7 저장하기와 불러오기

scala.xml.XML.save("therm1.xml", node)

val loadnode = xml.XML.loadFile("therm1.xml")
fromXML(loadnode)


// 28.8 XML에 대해 패턴 매치하기

def proc(node: scala.xml.Node): String =
  node match {
    case <a>{contents}</a> => "It's an a: "+ contents
    case <b>{contents}</b> => "It's a b: "+ contents
    case _ => "It's somthing else."
  }

proc(<a>apple</a>)
proc(<b>banana</b>)
proc(<c>chrry</c>)

proc(<a>a <em>red</em> apple</a>)
proc(<a/>)

def proc(node: scala.xml.Node): String =
  node match {
    case <a>{contents @ _*}</a> => "It's an a: "+ contents
    case <b>{contents @ _*}</b> => "It's a b: "+ contents
    case _ => "It's somthing else."
  }

proc(<a>a <em>red</em> apple</a>)
proc(<a/>)

val catalog =
  <catalog>
    <cctherm>
      <description>hot dog #5</description>
      <yearMade>1952</yearMade>
      <dateObtained>March 14, 2006</dateObtained>
      <bookPrice>2199</bookPrice>
      <purchasePrice>500</purchasePrice>
      <condition>9</condition>
    </cctherm>
    <cctherm>
      <description>Sprite Body</description>
      <yearMade>1964</yearMade>
      <dateObtained>April 28, 2003</dateObtained>
      <bookPrice>1695</bookPrice>
      <purchasePrice>595</purchasePrice>
      <condition>5</condition>
    </cctherm>
  </catalog>

catalog match {
  case <catalog>{therms @ _*}</catalog> =>
    for (therm <- therms)
      println("processing: "+
        (therm \ "description").text)
}

catalog match {
  case <catalog>{therms @ _*}</catalog> =>
    for (therm @ <cctherm>{_*}</cctherm> <- therms)
      println("processing: "+
        (therm \ "description").text)
}
