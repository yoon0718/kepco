menu = {'김밥' : {'원조김밥' : 2500, '참치김밥' : 3000, '김치김밥' : 3000},
        '돈까스' : {'돈까스' : 7000, '왕돈까스' : 8000, '치즈돈까스' : 7500},
        '분식' : {'유부우동' : 5000, '쫄면' : 6000, '라뽂이' : 5000},
        '식사' : {'카레덮밥' : 6000, '제육덮밥' : 6500, '오므라이스' : 6500},
        '국밥' : {'갈비탕' : 7000, '순대국' : 7000, '부대찌개' : 7000},
        '사이드메뉴' : {'콜라(250ml)' : 1000, '공기밥' : 1000, '계란찜' : 5000}}

system = True
msl = [0]
mnl = [0]
while(system):
        systemMenu = int(input('시스템 메뉴를 고르시오. 1. 메뉴판보기 2. 주문하기 3. 결제하기 4. 영수증보기'))

        if systemMenu == 1:
                print(f'|{list(menu.keys())[0]:^12}|{list(menu.keys())[1]:^10}|{list(menu.keys())[2]:^10}|{list(menu.keys())[3]:^10}|{list(menu.keys())[4]:^10}|{list(menu.keys())[5]:^10}|')
                print(f'|{list(list(menu.values())[0])[0]:^10}|{list(list(menu.values())[1])[0]:^10}|{list(list(menu.values())[2])[0]:^10}|{list(list(menu.values())[3])[0]:^10}|{list(list(menu.values())[4])[0]:^10}|{list(list(menu.values())[5])[0]:^10}|')
                print(f'|{list(list(menu.values())[0])[1]:^10}|{list(list(menu.values())[1])[1]:^10}|{list(list(menu.values())[2])[1]:^10}|{list(list(menu.values())[3])[1]:^10}|{list(list(menu.values())[4])[1]:^10}|{list(list(menu.values())[5])[1]:^10}|')
                print(f'|{list(list(menu.values())[0])[2]:^10}|{list(list(menu.values())[1])[2]:^10}|{list(list(menu.values())[2])[2]:^10}|{list(list(menu.values())[3])[2]:^10}|{list(list(menu.values())[4])[2]:^10}|{list(list(menu.values())[5])[2]:^10}|')
        elif systemMenu == 2:
                ms = str(input('시키실 메뉴를 적으시오. : '))
                mn = int(input('수량을 적으시오. : '))
                for i in range(len(menu)): ##시킨메뉴 가격찾기
                        for j in range(len(list(list(menu.values())[i]))):
                                if list(list(menu.values())[i])[j] == ms:
                                        a = list(menu.values())[i]
                                        mm = a[ms] ## 찾은 가격
                                        print(1)
                                        break
                    
                for i in range(len(msl)): 
                        if msl[i] == ms:
                                mnl[i] = mnl[i] + mn*mm   ###### 이부분 한참 잘못됨 주말동안 뜯어봐
                                print(2)
                                break
                        else: 
                                msl.append(ms)
                                mnl.append(mn*mm)
                                print(3)
                                print(ms, mnl[i+1])
                                break
                print(4)

                print(ms, mn, mm, msl, mnl)
        elif systemMenu == 3:
                print("결제를 시작합니다. 총 결제금액 {0} 원 입니다".format(sum(mnl)))
                pay = int(input('결제는 무엇으로 하시겠습니까? 1. 현금 / 2. 카드'))
                if pay == 1:
                        pm = int(input('현금을 결정하셨습니다. 얼마를 지불하시겠습니까?'))
                        print("거스름돈 {0}원 입니다. 감사합니다.".format(pm - sum(mnl)))

                else:
                        print("결제완료되셨습니다.")