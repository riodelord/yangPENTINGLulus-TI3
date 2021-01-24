from typing import Optional

from fastapi import FastAPI
from pydantic import BaseModel
from typing import List

from db.sql import get_sensors, get_alarms, get_utility

app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "World"}


@app.get("/sensor/{th_id}")
def read_sensor(th_id: int):
    rs = get_sensors(th_id)
    return {"th_id": th_id, "oid_hum": rs[0][0], "value_hum": rs[0][1], "oid_temp": rs[1][0], "value_temp": rs[1][1]}

@app.get('/utilities/{billing_id}')
def read_utilities(billing_id: int):
    prices, dates = get_utility(billing_id)
    return {"prices": prices, "dates": dates}

@app.get('/alarms')
def read_alarms()
    rs = get_alarms()
    return {"alarms"}

@app.get("/items/{item_id}")
def read_item(item_id: int, q: Optional[str] = None):
    return {"item_id": item_id, "q": q}