
## 基础数据结构

### 数组和链表

二者都是物理结构


|      | 查找 | 更新 | 插入 | 删除 |
| :--: | :--: | :--: | :--: | :--: |
| 数组 | O(1) | O(1) | O(n) | O(n) |
| 链表 | O(n) | O(1) | O(1) | O(1) |

#### 数组

适合读多操作少

* 内存中顺序存储的相同元素的集合
* 访问速度快
* 插入删除操作慢,需要移动其他元素

#### 链表

* 物理上非连续、非顺序、随机存储的数据结构
* 插入删除操作灵活
* 访问速度慢


### 栈和队列

二者都是线性逻辑结构，存储删除的时间复杂度都是O(1)，物理实现可以用数组或者链表。

#### 栈
先进后出（First In Last Out , FILO）的线性数据结构

对于历史的回溯
* 栈底、栈顶、入栈(push)、出栈(pop)

#### 队列

先进先出（First In First Out， FIFO）的线性数据结构

对于历史的回放
* 队头、队尾、入队（enqueue）、出队(dequeue)


### 哈希表（散列表）

存储Key-Value的集合，接近O(1)的的时间进行读写操作。通过哈希函数实现KEY和角标的转换，
通过开放寻址方法或者链表方法来解决冲突。

#### 1.链表法

数据存储区域的数据类型为单链表，出现碰撞的时候往链表后追加数据

#### 2.开放寻址

* 线性探测，依次后移，类似循环遍历，每次找一个位置。会有**一次聚集**问题
* 平方探测，在线性探测基础上，以索引的平方值寻找索引
* 双哈希：内部结构是两个hash表，通过hash找到Key的位置，然后再次hash找到数据存放位置

#### 3.再哈希

当哈希表存储数据近满状态的时候，负载因子接近1（表内数据数量和表容量的比例），这个时候就要重新创建更大容量的表，然后将所有数据重新进行哈希计算，赋值到新的表。这个过程是再哈希