//
// Created by mac on 2019/9/15.
//
#include <string>

using namespace std;

/**
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：

"G"：直走 1 个单位
"L"：左转 90 度
"R"：右转 90 度
机器人按顺序执行指令 instructions，并一直重复它们。

只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。

 * */
class Solution {
public:
    /**
     * 思路:
     * 每一轮的运动都可以转变成一个Vector运动向量
     * 设计为 (x,y,degree).
     * x: x轴方向的位移，以右为正方向
     * y: y轴方向的位移,以上为正方向
     * degree: 旋转角度.逆时针为正
     * 比如第一个例子GGLLGG , 实际上就是位移了 （0，0，180°）
     * 第二个例子GG , 就是位移了 (0,2,0°)
     * 第三个例子GL , 就是位移了 (0,1,90°)
     * 我们再考虑一次instruction对之前的位移的影响. 假设之前的位移是 T(x,y,degree,D). 机器人的头对准的方向是 D . (Up,Down,Left,Right)
     * 如果是G .
     *  if D is Up : T_next = (x,y+1,degree,D)
     *  if D is Down : T_next = (x,y-1,degree,D)
     *  if D is Left : T_next = (x-1,y,degree,D)
     *  if D is Right : T_next = (x+1,y,degree,D)
     *
     * 如果是L .
     *  if D is Up : T_next = (x,y,)
     *
     *  如果运行完之后,
     *      留在原地, 那么返回true
     *      方向不变, 那么返回false
     *      方向改变, 那么返回true
     *  所以需要判定最后是否方向改变即可
     * */
    bool isRobotBounded(string instructions);
};

bool Solution::isRobotBounded(string instructions) {


    return false;
}
