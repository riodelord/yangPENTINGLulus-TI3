import mysql.connector as mc

HOST_NAME = 'localhost'
USER_NAME = 'root'
DATABASE_NAME = 'emsandroid'

def get_sensors(th_id):
    cnx = mc.connect(
        host=HOST_NAME,
        user=USER_NAME,
        password='',
        database=DATABASE_NAME)
    q = "SELECT oid_name, value FROM t_th_log_val WHERE th_id = {} ORDER BY id DESC LIMIT 2".format(th_id)
    cursor = cnx.cursor()
    cursor.execute(q)
    rs = cursor.fetchall()
    cursor.close()
    cnx.close()
    return rs

def get_alarms():
    cnx = mc.connect(
        host=HOST_NAME,
        user=USER_NAME,
        password='',
        database=DATABASE_NAME)
    q = "SELECT * FROM t_alarms"
    cursor = cnx.cursor()
    cursor.execute(q)
    rs = cursor.fetchall()
    cursor.close()
    cnx.close()
    return rs

def get_utility(billing_id):
    cnx = mc.connect(
        host=HOST_NAME,
        user=USER_NAME,
        password='',
        database=DATABASE_NAME)
    #
    # Billing-id 1 -> siang
    # Billing-id 2 -> malam
    #
    q = "SELECT billing_id, total_price, DATE_FORMAT(log_date, '%d %b %Y') AS log_dated FROM t_kwh_daily_sum WHERE billing_id = {} AND MONTH(log_date) = MONTH('2020-08-01') AND YEAR(log_date) = YEAR('2020-08-01') GROUP BY log_date ORDER BY id".format(billing_id)
    cursor = cnx.cursor()
    cursor.execute(q)
    prices, dates = list(), list()
    for billing_id, total_price, log_dated in cursor:
        prices.append(total_price)
        dates.append(log_dated)
    cursor.close()
    cnx.close()
    return prices, dates