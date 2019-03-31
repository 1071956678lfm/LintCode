def deal(val):
    for x in val[:-1]:
        print('%.2f' % x, end=' ')
    print('%.2f' % val[-1])


di = eval(input())
