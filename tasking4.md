
需求：作为一个超级停车小弟，我能够将车停在空置率最高的那个停车场，并可以取出.

Give 一个super小弟和2个停车场和一辆车，第一个停车场空置率为100%，第二个停车场空置率为10%，
when super小弟停车
then super小弟将车停入第一个停车场，并拿到票

Give 一个super小弟和2个停车场和一辆车，第一个停车场空置率为10%，第二个停车场空置率为100%，
when superv小弟停车
then super小弟将车停入第二个停车场，并拿到票

Give 一个super小弟和2个未满停车场和一辆车，第一个和第二个停车场空置率都是100%，
when super小弟停车
then super小弟将车停入第一个停车场，并拿到票

Give 一个super小弟和2个停车场和一辆车，停车场全部已满
when super小弟停车
then 停车失败，没有拿到票

Give 一个super小弟和2个停车场和正确的票
when super小弟取车
then 取到正确的车

Give 一个super小弟和2个停车场，和一张无效的票
when super小弟取车
then 小弟取车失败,返回票无效

Give 一个super小弟和2个停车场，和一张已取过车的票
when super小弟取车
then super小弟取车失败,返回票无效




