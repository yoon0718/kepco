do_list = []
for i in range(3):
    a = int(input("{0}번째 숫자를 입력하시오".format(i+1)))
    do_list.append(a)

print(sum(do_list))
print(int(sum(do_list) / len(do_list)))
    

    
