
##Description
The distributed operation layer (DOL) is a software development framework to program parallel applications. The DOL allows to specify applications based on the Kahn process network model of computation and features a simulation engine based on SystemC. Moreover, the DOL provides an XML-based specification format to describe the implementation of a parallel application on a multi-processor systems, including binding and mapping.
![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/pic/pic1.png)





##How to install
###1.安装必要的开发环境
 * $    sudo apt-get update
 * $    sudo apt-get install ant
 * $     sudo apt-get install openjdk-7-jdk
 * $    sudo apt-get install unzip



###2.解压文件
 * 新建dol的文件夹 
 * $    mkdir dol
 * 将dolethz.zip解压到 dol文件夹中
 * $	unzip dol_ethz.zip -d dol
 * 解压systemc
 * $	tar -zxvf systemc-2.3.1.tgz


###3.编译systemc
 * 解压后进入systemc-2.3.1的目录下
 * $    cd systemc-2.3.1
 * 新建一个临时文件夹objdir
 * $	mkdir objdir
 * 进入该文件夹objdir
 * $	cd objdir
 * 运行configure
 * $	../configure CXX=g++ --disable-async-updates


![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/pic/pic2.png)

 * 编译
 * $    sudo make install
 * 编译完后文件目录如下($ cd ..        $ ls
 * 实验截图：
![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/pic/pic3.png)

 * 记录当前的工作路径(会输出当前所在路径，记下来，待会有用)
 * $    pwd
 * 实验截图：
 *
![](https://raw.githubusercontent.com/rowlingggg/ES2016_14353398/master/pic/pic4.png)

 * 进入刚刚dol的文件夹
 * $    cd ../dol
 * 修改build_zip.xml文件
 * 找到下面这段话，
 * property name="systemc.inc" value="/home/zel/14353398/Downloads/systemc -2.3.1/include"
 * property name="systemc.lib" value="/home/zel/14353398/Downloads/systemc -2.3.1/lib-linux/libsystemc.a"
 * 由于linux为64版本，所以改为linux64


###4.编译dol
*然后是编译
*$    ant -f build_zip.xml all
*若成功会显示build successful
###到这一步虽然我的ubuntu显示成功了，但是运行第一个例子还是失败的，应该是因为我的ubuntu是16.04，默认没有openjdk7，所以要手动建立仓库

####但是种种原因。。。我的虚拟机重新装到了硬盘上以后，第一步执行失败了，故借用管哥的ubuntu。。。


##Experimental experience
###实验感想
* 1.ubuntu的dol配置，在一开始的过程中似乎都很顺利，但在最后一步却failed了，应该是因为openjdk7的问题，还有就是systemc中pwd出来的路径是不对的。
* 2.在一开始的命令中输入sudo gedit 总是会有权限问题发生error，修改文件会有产生问题，好像是要用到gksudo才可以解决，因为后面直接用了ta配好的ubuntu所以就没有尝试
* 3.上课TA讲到的git和github听的一头雾水，但其实看了廖雪峰老师的教程网站后清晰很多，基本没有难点，但重要的是要清楚了解网站上关于git仓库工作区暂存区和master这些的概念和仓库的工作流程。
* 4.关于markdown语言，百度了markdown并用了一个网页版本的编辑器进行编写，感觉类似于html并且更加简洁易懂的语言，排版字体等都容易上手。图形的url，利用跟html类似的原理，我是讲图片统一放在我的github仓库中，在github哪里打开我的图片生成图片的url，这样就可以显示出图片了。

