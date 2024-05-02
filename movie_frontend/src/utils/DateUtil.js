export function format_datetime_yyyymmdd_hhmm(data) {
  const date = new Date(data)
  // 2024-04-01 03:05
  let datePart = [
    date.getFullYear(),
    date.getMonth() + 1,
    date.getDate()
  ].map((n, i) => n.toString().padStart(i != 0 ? 2 : 4, '0')).join('-')
  let timePart = [
    date.getHours(),
    date.getMinutes()
  ].map((n, i) => n.toString().padStart(2, '0')).join(':')
  return datePart + ' ' + timePart
}

export function format_datetime_yyyymmdd(data) {
  const date = new Date(data)
  // 2024-04-01 03:05
  let datePart = [
    date.getFullYear(),
    date.getMonth() + 1,
    date.getDate()
  ].map((n, i) => n.toString().padStart(i != 0 ? 2 : 4, '0')).join('-')
  return datePart
}

export function format_date_ddmmyyyy(data) {
  const date = new Date(data)
  // 2024-04-01 03:05
  let datePart = [
    date.getDate(),
    date.getMonth() + 1,
    date.getFullYear()
  ].map((n, i) => n.toString().padStart(i != 2 ? 2 : 4, '0')).join('-')
  return datePart
}

export function format_time_hhmm(data) {
  const date = new Date(data)

  const hour = data.substring(0, 2)
  const minute = data.substring(3, 5)

  var formatted_hour
  var period
  if (hour == 0 || hour == '00') {
    formatted_hour = 12
    period = 'AM'
  } else if (hour > 12) {
    formatted_hour = hour - 12
    period = 'PM'
  } else {
    formatted_hour = hour
    period = 'AM'
  }
  return formatted_hour + ':' + minute + ' ' + period
}
