#coding=utf-8
# 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import sys 

if __name__ == '__main__':
    def computeHeight(w, b):
        h = 1
        while h * (h + 1) / 2 < w + b:
            h += 1
        return min(h, w, b)


    def compute_count(white, black, maxHeight, curHeight):
        if maxHeight == curHeight:
            # 达到了最底层
            return 1
        # 否则添加一层新的
        ans = 0
        curHeight += 1
        if white >= curHeight:
            # 下一层作为白色
            ans += compute_count(white - curHeight, black,
                                 maxHeight, curHeight)
        if black >= curHeight:
            ans += compute_count(white, black - curHeight,
                                  maxHeight, curHeight )
        return ans


    max_h = 0
    w, b = [eval(x) for x in sys.stdin.readline().strip().split()]
    maxHeight = computeHeight(w, b)  # 得到最大高度
    count = compute_count(w, b, maxHeight, 0)
    print('{} {}'.format(maxHeight, count))