# Date
一个日期和时间的相关计算的工具类。

1. 月日从 1 开始计数
2. 一周从周一开始，即周一为 1，周日为 7

## 导入
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.1djmao:Date:v1.0'
	}



## 接口

### Date 类
#### 使用年月日构造
Date(int year, int month, int dayInMonth)
#### 使用年和年份日期构造
Date(int year,int dayInYear)
#### 获取今天
Date getToday()
#### 格式化输出
String formatOut() ，结果示例：“2018-05-05”
#### 自定义格式化输出
String formatOut(String format)

format 规则：

1. 根据自定义格式输出字符串，如 "y-m-d 周w"输出 "2017-01-02 周一"
2. 都是小写
3. y 表示 年
4. m 表示 月
5. d 表示 日期
6. w 表示 星期

#### 根据格式化输出结果构造 Date
Date formatFrom(String date,String format)

1. 必须包含年月日三个参数
2. format 规则同上
#### 通过 get 方法获取到的变量
```
int year;
int month;
int dayInWeek;
int dayInMonth;
int dayInYear;
int weekInMonth;
int weekInYear;
```

### Time 类
#### 使用时间戳构造 Time类实例 
Time(long timeMillis)
#### 获取现在的时间 
getNowTime()
#### 格式化输出 
formatOut() ，输出结果示例 “2018-05-05 10:32:38”
#### 通过 get 方法获取到的变量
```
Date mDate;
int hour;
int minute;
int second;
long timeMillis;
```

### Calendar 类
#### 获取某年某周的所有日期
Date[] getWeekDays(int year,int weekInYear)
#### 获取某年某月某周的所有日期
Date[] getWeekDays(int year,int month,int weekInMonth)
#### 获取某年某月所有日期
Date[] getMonthDays(int year,int month)
#### 获取某天的前一天
Date getLastDate(Date date)
#### 获取某天的后一天
Date getNextDate(Date date)
#### 比较两个日期的大小
compareDate(Date date1,Date date2)
#### 是否是闰年
boolean isLeapYear(int year)
#### 获取某月的天数
int getDayCountByMonth(int year,int month)
#### 获取某年的天数
int getDayCountByYear(int year)
#### 根据年月日获取周几
int getDayInWeekByDay(int year,int month,int dayInMonth)

