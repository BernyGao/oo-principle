Give 一个smart小弟和2个停车场和一辆车，第一个停车场空位比第二个停车场多，例如：第一个停车场有2个空位，第二个停车场有1个空位，
when smart小弟停车 
then smart小弟将车停入第一个停车场，并拿到票

Give 一个smart小弟和2个停车场和一辆车，第二个停车场空位比第一个停车场多，例如：第一个停车场有1个空位，第二个停车场有2个空位，
when smart小弟停车 
then smart小弟将车停入第二个停车场，并拿到票

Give 一个smart小弟和2个未满停车场和一辆车，第一个和第二个停车场都有2个空位
when smart小弟停车 
then smart小弟将车停入第一个停车场，并拿到票

Give 一个smart小弟和2个停车场和一辆车，停车场全部已满 
when smart小弟停车
then 停车失败，没有拿到票

Give 一个smart小弟和2个停车场和正确的票
when smart小弟取车
then 取到正确的车

Give 一个smart小弟和2个停车场，和一张无效的票
when smart小弟取车
then 小弟取车失败,返回票无效

Give 一个smart小弟和2个停车场，和一张已取过车的票
when smart小弟取车
then smart小弟取车失败,返回票无效




 