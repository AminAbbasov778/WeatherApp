package com.example.weatherapp.UseCases

import javax.inject.Inject


class UseCaseCollector @Inject constructor(
    var averageForecastsOfDayUseCase: AverageForecastsOfDayUseCase,
    var averageTomorrowForecastUseCase: AverageTomorrowForecastUseCase,
    var dateListUseCase: DateListUseCase,
    var dateUseCase: DateUseCase,
    var dayOfMonthUseCase: DayOfMonthUseCase,
    var fiveDaysHourlyForecastToMapUseCase: FiveDaysHourlyForecastToMapUseCase,
    var formatedHourlyForecastListUseCase: FormatedHourlyForecastListUseCase,
    var formatTempForAdapterUseCase: FormatTempForAdapterUseCase,
    var iconUrlUseCase: IconUrlUseCase,
    var monthWithNumberToMonthWithWords: MonthWithNumberToMonthWithWordsUseCase,
    var roundUseCase: RoundUseCase,
    var timeUseCAse: TimeUseCAse,
    var sumAverageDataUseCase: AverageDataUseCase,
    var theLastStepForFiveDaysForecastUseCase: TheLastStepForFiveDaysForecastUseCase,
    var mostUsedWeatherIconInADayUseCAse: TheMostUsedWeatherIconInADayUseCAse,
    var tomorrowDateUseCase: TomorrowDateUseCase,
    var tomorrowDayOfMonthUseCase: TomorrowDayOfMonthUseCase,
    var tomorrowHourlyForecastListUseCase: TomorrowHourlyForecastListUseCase,
    var unixTimeToCurrentFormatUseCase: UnixTimeToCurrentFormatUseCase,
    var wayThatFindTheMostUsedIconUseCase: WayThatFindTheMostUsedIconUseCase,
    var weatherDataFromApiUseCase: WeatherDataFromApiUseCase,
    var hourlyForecastDataFromApiUseCase: HourlyForecastDataFromApiUseCase,
    var tomorrowAndFiveDaysButtonsAreFalseUseCase: TomorrowAndFiveDaysButtonsAreFalseUseCase,
    var liveDataOfTomorrowHourlyForecastUseCase: LiveDataOfTomorrowHourlyForecastUseCase,
    var  tomorrowButtonIsTrueUseCase: TomorrowButtonIsTrueUseCase,
    var liveDataOfForecastResponseForDayUseCsse: TomorrowLiveDataOfForecastResponseForDayUseCase,
    var todayLiveDataOfForecastresponseForDayUseCase: TodayLiveDataOfForecastresponseForDayUseCase

    ) {
}