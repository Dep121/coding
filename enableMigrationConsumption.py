import requests
import json
import csv

from time import sleep
if __name__ == "__main__":
    filenameRequests = 'issueData.csv'
    url = 'https://ops-panel-api.whitehatjr.com/api/V1/students/updateStudentCoursePreference'
    token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlblZlcnNpb24iOjcsImlkIjoiY2ZkNDE1NzMtODc2OC00NjE4LWE0NTAtMmQ1ZGQ1YTM3ZWQ1IiwidG9rZW5UeXBlIjoicHJpbWFyeV90b2tlbiIsImV4cCI6MTY2MDU1MjI5MSwiaWF0IjoxNjUyNzc2MjkxfQ.cJcn3K6-KLcWPzERYn0-tIXVcN2JiW4rnsGCgfsc82k'
    print('starting...')
    success = []
    successUID = []
    failedUID = []
    notdone = []
    count = 0
    with open(filenameRequests) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0
        for row in csv_reader:
            studentId = row[0]
            sc_id = row[1]
            # courseType = row[4]
            # paidData = row[5]
            print('Req for student: ', studentId)
            try:
                
                headers = {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + token
                }
                dat = {
                        "data": {
                            "studentPreference": {
                                "experiments": {
                                    "minAttendancePolicy": {
                                        "enabled": True,
                                        "enabledOn": "2022-04-30T00:00:00"
                                    }
                                },
                                "creditLapseConfig": {
                                    "consumptionCycleType": "monthly_calendar",
                                    "minCreditsPerCycle": "4",
                                    "maxCreditsPerCycle": "10",
                                    "graceDays": 1
                                }
                            },
                            "studentCourse": {
                                "sc_id": sc_id,
                                "studentId": studentId
                            }
                        }
                    }
                response = requests.put(url, headers=headers, json=dat, timeout=30)
                response.raise_for_status()
                count +=1
                suc = {
                    "uid": studentId
                }
                success.append(suc)
                successUID.append(studentId)
            except requests.exceptions.HTTPError as err:
                print("Failed", err)	
                failedUID.append(studentId)
            except requests.exceptions.ConnectionError as errc:
                print("Failed ConnectionError")	
                failedUID.append(studentId)
            except requests.exceptions.Timeout as errt:
                print("Failed Timeout")	
                failedUID.append(studentId)
            except requests.exceptions.RequestException as err:
                print("Failed RequestException")	
                failedUID.append(studentId)
            
            if count%10 == 0:
                print("Reached 10 count")
                print(count)
                sleep(2)

    data = {
        "failedUID": failedUID,
        "notDoneUID": notdone,
        "successUID": successUID,
        "success": success
    }

    print("count is")
    print(count)

    with open(r'resp_token.json', 'w', encoding='utf-8') as jsonf:
        jsonf.write(json.dumps(data, indent=4))

    print('File written')