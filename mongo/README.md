mongodb的使用

mongodb： （1）dbs(相当于数据库中的database) 
               可以新建一个dbs 如（use long）创建了一个dbs名字为long的dbs  
          （2）collection （相当于数据库中的表） 
               db.createCollection(name, options) 
               
                 
 常用命令  show dbs(查看数据库)
           show collections（查看集合）
           db.colName.find() (查看mycol集合中数据  db.mycol.find())
           db.colName.fidnd().pretty() (格式化输出查询结果)