# 手动实现RPC框架
一、服务提供端启动  
1.提供服务接口及实现类； HelloService  HelloServiceImpl  
2.在远程注册中心注册[接口名->URL]映射; RemoteMapRegister  
3.本地保存[服务接口->服务实现类]映射；LocalRegister  
4.启动服务提供者，不同RPC协议操作有所不同。HTTP协议时启动tomcat服务器，监听HTTP请求；HttpProtocol  HttpServer  

二、服务消费端发送请求  
1.通过代理隐藏底层调用细节； ProxyFactory  
2.根据服务接口名从注册中心获得服务地址列表，并根据负载均衡策略选定调用地址；RemoteMapRegister  
3.利用RPC协议向服务端发送调用请求，封装传递RPC需要的参数（接口名、方法名、参数类型、参数值)；HttpProtocol HttpClient  
  
三、服务提供端处理请求  
1.根据消费端传递的接口名从本地获取服务具体实现字节码对象，利用反射实现接口调用；HttpServerHandler  
2.将调用结果返回给客户端。  
