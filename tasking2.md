Give 一个小弟和三个停车场和一辆车，第一个停车场未满
when 小弟停车 
then 小弟将车停入第一个停车场，并拿到票

Give 一个小弟和三个停车场和一辆车，第一个停车场已满，第二个停车场未满
when 小弟停车 
then 小弟将车停入第二个停车场，并拿到票

Give 一个小弟和三个停车场和一辆车，第一个和第二个停车场都已满，第三个停车场未满
when 小弟停车 
then 小弟将车停入第个停车场，并拿到票

Give 一个小弟和2个停车场和一辆车，停车场全部已满 
when 小弟停车
then 停车失败，没有拿到票

Give 一个小弟和2个停车场和正确的票
when 小弟取车
then 取到正确的车

Give 一个小弟和2个停车场，和一张无效的票
when 小弟取车
then 小弟取车失败,返回票无效

Give 一个小弟和2个停车场，和一张已取过车的票
when 小弟取车
then 小弟取车失败,返回该车已取出




 