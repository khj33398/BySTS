<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
        function Account(id,name,money) {
            this.id=id;
            this.name=name;
            this.balance=money;
            this.info = function() {
                return "id:"+this.id+", name:"+this.name+", balance:"+this.balance;
            };
            this.deposit = function(money) {
                if(money>0) {
                    this.balance+=money;
                }
            };
            this.withdraw = function(money) {
                if(this.balance>=money) {
                    this.balance-=money;
                }
            };
        }

        function Bank() {
            this.accs = [];
            this.makeAccount = function() {
                let id = +prompt('계좌번호');
                let name = prompt('이름');
                let balance = +prompt('입금액');
                this.accs.push(new Account(id,name,balance));
            }
            this.deposit = function() {
                let id = +prompt('계좌번호');
                let money = +prompt('입금액');
                let acc = this.accs.find(acc=>acc.id==id);
                acc.deposit(money);
            }
            this.withdraw = function() {
                let id = +prompt('계좌번호');
                let money = +prompt('출금액');
                let acc = this.accs.find(acc=>acc.id==id);
                acc.withdraw(money);
            }
            this.accInfo = function() {
                let id = +prompt('계좌번호');
                let acc = this.accs.find(acc=>acc.id==id);
                console.log(acc.info());
            }
            this.allAccInfo = function() {
                this.accs.forEach((acc,index)=>{
                    console.log(acc.info());
                });
            }
            this.toJsonStr = function () {
                //계좌번호 입력받아 계좌를 검색한 후 json string으로 변경하여 출력
                let id = +prompt('계좌번호');
                let acc = this.accs.find(acc=>acc.id==id);
                let accstr = JSON.stringify(acc);
                console.log(accstr);
            }
            this.toJsonObj = function() {
                //json string 형태의 데이터를 입력받아 Account 객체로 생성하여 배열에 추가
                let accstr = prompt('JSON 형태 계좌정보');
                let acc = JSON.parse(accstr);
                this.accs.push(new Account(acc.id, acc.name, acc.balance));
            }
            this.toAllJsonStr = function() {
                //전체 계좌목록을 json string으로 변경하여 출력
                this.accs.forEach((acc,index)=>{
                    console.log(JSON.stringify(acc));
                });
            }
        }

        let bank = new Bank;
        bank.makeAccount(); //prompt를 이용하여 계좌번호, 이름, 입금액을 입력받아 객체 생성하여 배열에 저장
        bank.toJsonStr();
        bank.toJsonObj();
        bank.toAllJsonStr();
        // bank.accInfo(); //prompt를 이용하여 계좌전호를 입력받아 계좌 조회 후 출력, find 이용
        // bank.deposit(); //prompt를 이용하여 계좌번호와 입금액을 입력받아 입금처리, find 이용
        // bank.accInfo(); //prompt를 이용하여 계좌전호를 입력받아 계좌 조회 후 출력, find 이용
        // bank.withdraw(); //prompt를 이용하여 계좌번호와 출금액을 입력받아 출금처리, find 이용
        // bank.accInfo(); //prompt를 이용하여 계좌전호를 입력받아 계좌 조회 후 출력, find 이용
        bank.allAccInfo(); //전체 계좌 조회 출력, forEach 이용

        // let accs = [];
        // accs.push(new Account(1001,"홍길동", 100000));
        // accs.push(new Account(1002,"고길동", 200000));
        // accs.push(new Account(1003,"김길동", 300000));
        // accs.push(new Account(1004,"차길동", 400000));
        // accs.push(new Account(1005,"박길동", 500000));
        // accs.push(new Account(1006,"김길동", 500000));

        // function func(item,index,array) {
        //     console.log(item.info());
        // }
        // accs.forEach(func);
        // let acc = accs.find(item=>item.name=="김길동");
        // console.log(acc.info()); //id:1003, name:김길동, balane:300000

        // let list = accs.filter(item=>item.name=="김길동");
        // for(let acc of list) {
        //     console.log(acc.info()); 
        // }

        // let acc = new Account(1001,"홍길동",100000);
        // console.log(acc.info());  //id:1001, name:홍길동, balane:10000
        // acc.deposit(1000);
        // console.log(acc.info());  //id:1001, name:홍길동, balane:11000
        // acc.withdraw(500);
        // console.log(acc.info());  //id:1001, name:홍길동, balane:10500

    </script>
</head>
<body>

</body>
</html>