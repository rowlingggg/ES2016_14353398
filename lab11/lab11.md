
#                                                   LAB11 实验报告


###实验任务
1. 熟悉Keil调试器的使用
2. 运行代码，观察Registers和Memory的值的变化
3. 找出Cnt变量的最终值和HappyBuf的最终值，并截图。实验报告需给出该截图，并解释如何得出结论








###实验步骤


1. 将keil进行安装，安装路径为E:/

2. 打开工程进行debugging。工程代码包括main.s 和 sartup.s

3. 其中，startup.s 为cpu基本初始化程序，main.s为主程序

4. main.s程序有两个缓冲区HappyBuf和SadBuf，程序将sad和happy两个8位变量赋为随机数，再将这两个变量转存到数组中。Cnt保存数组偏移量，Cnt被初始化为0，转存时先判断Cnt是否越界，若否，则将变量转存再将Cnt加1

5. 大致知道main.s程序的运行意义后，运行main.s，观察寄存器R的结果。

6. 初始化时，初始的寄存器如图下所示：
  * ![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/lab11_pic/lab11_1.png)
7. 根据main.s可以看到，R4、R5分别表示存储sad和happy的寄存器，Cnt的值用R1寄存器进行存储，且初始化为0。R0用来存储产生的低8位随机数，分别要赋值给R4，R5。R13为堆栈指针SP，R14为子程序链接寄存器LR,R15为程序计数器PC。

8. 最终可以看到如下结果：即Cnt的最终值为R1=0x00000014，也就是数组偏移量Cnt=20时，为最终值，如果越界，则不会再+1.
   此时，HappyBuf的最终值为R2 = 0x2000002c。
 * ![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/lab11_pic/lab11_2.png)
9. 在main.s中，首先初始化并且对每个值分配空间，然后在loop中，调用子程序Random产生随机数分配给寄存器R4，R5，也就是前面说到的分别给sad和happy进行赋值，然后对Cnt的值进行比较，如果不越界，则+1，将此时数据放入缓冲区中，
   然后Cnt偏移一位，即Cnt+1.
10. 当Cnt=20时，不再递增，此时数组已经越界，此时寄存器R2的值即为缓冲区Happybuf的最终值
***






***


















