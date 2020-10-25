## 文件上传

    
### 分布式文件系统
  (1) 什么是分布式文件系统
    A、随着文件数据越来越多，通过tomcat或nginx虚拟化的静态资源文件在单一的一个服务器结点内是存不下的，
  如果用多个结点来存储也可以，但是不利于管理和维护，所以需要一个系统来管理多台计算机节点上的文件数据，
  这就是分布式文件系统；
    B、分布式文件系统是一个允许文件通过网络在多台节点上分享的文件系统，多台计算机节点共同组成一个整体，
  为更多的用户提供分享文件和存储空间。比如常见的网盘，本质就是一个分布式文件存储系统。虽然我们是一个
  分布式文件系统，但是对用户来说是透明的，用户使用的时候，就像访问本地磁盘一样；
    C、分布式文件系统可以提供冗余备份，所以容错能力很高。系统中有某些结点宕机，但是整体文件服务不会停止，
  还是能够为用户提供服务，整体还是运作的，数据也不会丢失；
    D、分布式文件系统可扩展性强，增加或减少结点都很简单，不会影响线上服务，增加完毕后会发布到线上，加入
  到集群中为用户提供服务；
    E、分布式文件系统可以提供负载均衡能力，在读取文件副本的时候可以由多个节点共同提供服务，而且可以通过
  横向扩展来确保性能的提升与负载。
  
  (2) 为什么要使用分布式文件系统
    可以解决：A、海量数据存储；B、文件数据高可用(冗余备份)；C、读写性能和负载均衡。
  
  (3) FastDFS 与 HDFS
    两者主要地位和应用场景不一样
    A、Hadoop中的文件系统HDFS主要解决并行计算中分布式存储数据的问题。单个数据文件通常很大，采用了分块
  (切分)存储的方式，所以是大数据大文件存储来使用的场景；
    B、FastDFS 主要用于互联网网站，为文件上传和下载提供在线服务。所以在负载均衡、动态扩容等方面都支持得
  比较好，FastDFS不会对文件进行分块存储。FastDFS用于存储小文件都是不错的，比如说用户头像、比较小的音视频文件等。
  
  
### 什么是FastDFS
  A、FastDFS 是一个开源的轻量级分布式文件系统。它对文件进行管理，功能包括：文件存储、文件同步、文件访问（文件上传、
文件下载）等、解决了大容量存储和负载均衡问题。特别适合以文件为载体的在线服务，如相册网站、视频网站等等。
  B、FastDFS为互联网量身定制，充分考虑了冗余备份、负载均衡、线性扩容等机制，并注重高可用、高性能等指标，
使用FastDFS很容易搭建一套高性能的文件服务器集群提供文件上传、下载等服务；
  C、FastDFS服务端有两个角色：跟踪器（tracker）和存储节点（storage）。跟踪器主要做调度工作，在访问上起负载均衡的作用；
  D、存储节点存储文件，完成文件管理的所有功能：就是这样的存储、同步和提供存取接口，FastDFS同时对文件的metadata进行管理。
所谓文件的metadata就是文件的相关属性，以键值对（key value）方式表示，如：width=1024，其中的key为width，value为1024。
文件metadata是文件属性列表，可以包含多个键值对。
  E、跟踪器和存储节点都可以由一台或多台服务器构成。跟踪器和存储节点中的服务器均可以随时增加或下线而不会影响线上服务。
其中跟踪器中的所有服务器都是对等的，可以根据服务器的压力情况随时增加或减少。
  F、为了支持大容量，存储节点（服务器）采用了分卷（或分组）的组织方式。存储系统由一个或多个卷组成，卷与卷之间的文件是
相互独立的，所有卷的文件容量累加就是整个存储系统中的文件容量。一个卷可以由一台或多台存储服务器组成，一个卷下的存储
服务器中的文件都是相同的，卷中的多台存储服务器起到了冗余备份和负载均衡的作用。
  G、在卷中增加服务器时，同步已有的文件由系统自动完成，同步完成后，系统自动将新增服务器切换到线上提供服务。
  H、当存储空间不足或即将耗尽时，可以动态添加卷。只需要增加一台或多台服务器，并将它们配置为一个新的卷，这样就扩大了
存储系统的容量。
  I、FastDFS中的文件标识分为两个部分：卷名和文件名，二者缺一不可。
  
  * 常见术语：
    tracker：追踪者服务器，主要用于协调调度，可以起到负载均衡的作用，记录storage的相关状态信息；
    storage：存储服务器，用于保存文件以及文件的元数据信息；
    group：组，同组结点提供冗余备份，不同组用于扩容；
    mata data：文件的元数据信息，比如长宽信息、图片后缀、视频的帧数等。
    
    
### 优缺点
  水平扩容   
  运维复杂   
  开发复杂   
  
  
### 云存储阿里OSS

  * SDK使用简单
  * 提供强大的文件处理功能
  * 运维零成本
  * 图形化管理控制台
  * CDN加速