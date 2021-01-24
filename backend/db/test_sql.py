import mysql.connector as mc

th_id = 21
billing_id = 1
oid_name = "Temp"
cnx = mc.connect(
    host='localhost',
    user='root',
    password='',
    database='emsandroid')
q = "SELECT billing_id, total_price, DATE_FORMAT(log_date, '%d %b %Y') AS log_dated FROM t_kwh_daily_sum WHERE billing_id = {} AND MONTH(log_date) = MONTH('2020-08-01') AND YEAR(log_date) = YEAR('2020-08-01') GROUP BY log_date ORDER BY id".format(billing_id)
cursor = cnx.cursor()
cursor.execute(q)
prices, dates = list(), list()
for billing_id, total_price, log_dated in cursor:
    prices.append(total_price)
    dates.append(log_dated)

print(prices)