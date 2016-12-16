// 리스트 18.1  변경 가능한 은행 계좌 클래스

class BankAccount {

  private var bal: Int = 0

  def balance: Int = bal

  def deposit(amount: Int) {
    require(amount > 0)
    bal += amount
  }

  def withdraw(amount: Int): Boolean =
    if (amount > bal) false
    else {
      bal -= amount
      true
    }
}



val account = new BankAccount
account deposit 100
account withdraw 80
account withdraw 80


class Keyed {
  def computeKey: Int = ???  // 이 부분에서 시간이 오래 걸린다.
}

class MemoKeyed extends Keyed {
  private var keyCache: Option[Int] = None
  override def computeKey: Int = {
    if (!keyCache.isDefined)
      keyCache = Some(super.computeKey)
    keyCache.get
  }
}
