
#LAB2实验报告
##lab2：DOL实例分析与编程


###实验任务
1. 理解并且分析example1、example2中关于generator，consumer，square的代码
2. 修改example1代码使得输出的两次房结果变为三次方结果
3. 修改example代码使得dot图中的square模块只有两个






###实验步骤

#####example1
1. 分析example1的square代码
 * ![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/example1_1.png)

2. 以及example1的xml代码
 * ![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/example1_2.png)
 * ![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/example1_3.png)
 
3. 修改square中的关键代码，使其输出为立方数
 * 在square的fire函数中进行修改

    if (p->local->index < p->local->len) {
        DOL_read((void*)PORT_IN, &i, sizeof(float), p);
        /********修改的地方***********/
        i = i*i*i;
        /****************************/
        DOL_write((void*)PORT_OUT, &i, sizeof(float), p);
        p->local->index++;
    }
`

4.输出结果 

![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/lab3_1.png)

5.example1的dot图

![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/lab3_2.png)



***
####example2

1. example运行结果图以及修改之前的dot图

![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/lab3_3.png)
![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/lab3_4.png)

2.xml分析

![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/exampl2_1.png)

3.修改xml文件，明白iterator的作用,iterator其实就是一个循环的square模块，一个模块中的运算为i*i，两个模块为i的四次方，三个模块则是i的四次方的平方，也就是i的8次方，一个递归的效果，iterator个数取决于variable的取值范围，variable取值范围取决于values的值。

![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/exampl2_2.png)

4.修改之后的dot图

![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/assignment/pic_lab3/lab3_5.png)




***
***
###实验感想
1. 这一次的实验是关于dol实例的分析和修改，代码的分析没有很大的难度，模块很清晰，.c和.h文件都比较容易看。.c文件大致分为init和fire模块，分别是初始化和执行信号发生的函数，主运算便在fire函数中。
2. 注意在修改文件时要获取权限，其实在每一次打开终端打命令前，可以输入 `sudo su`获得权限，或者获得777读写权限，这样在后面代码修改就回更加方便
3. 在build第一个例子example1时会有出现，值为0,1,4,9、。。。这样的情况，获得权限后将一阵个main文件夹中的example1文件夹删除后重新build即可。
4. 关于本地库和github的连接，在上一次的建立github和git本地库实验中就有学习到，然后每一次上传文件前进行git clone，每次传输文件采用三部曲即可
   `git add readme.md`
   `git commit -m "xxxx"`
   `git push`
5. 获取图片的URL可以使用图床工具，也可以直接上传到github中获取图片的url。



















