import random

class game():
    def __init__(self) -> None:
        self.comnumber = []
        self.usernumber = []
        self.first = 0
        self.second = 0



    def comrannumber(self): #랜덤숫자받기
        for i in range(3):
            r = random.randrange(10)
            while r in self.comnumber:
                r = random.randrange(10)
            self.comnumber.append(r)
        return self.comnumber
    
    def acomnumber(self):
        number = self.comnumber
        return number


    def usersnumber(self): #유저입력받기
        self.usernumber = []
        for i in range(3):
            a = int(input("{0}번째 숫자를 입력하시오.".format(i+1)))
            self.usernumber.append(a)
        return self.usernumber


    def decision(self): #판정하기
        self.first = 0
        self.second = 0
        for i in range(3):
            for j in range(3):
                if i == j and self.comnumber[i] == self.usernumber[j]:
                    self.first = self.first + 1
                elif i != j and self.comnumber[i] == self.usernumber[j]:
                    self.second = self.second + 1
                else:
                    pass
        return self.first, self.second
    
    def strike(self):
        strike = self.first
        ball = self.second
        return strike, ball
    

run = game()
print(run.comrannumber() , "첫번째")
for k in range(10):
    if run.strike()[0] == 3:
        print("승리하셨습니다. 게임을 종료합니다.")
        break
    
    print(run.usersnumber(), "두번째")
    print(run.decision(), "세번째")
    print(run.acomnumber())