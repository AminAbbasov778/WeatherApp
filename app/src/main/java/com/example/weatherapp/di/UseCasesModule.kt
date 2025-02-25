package com.example.weatherapp.di

import com.example.weatherapp.UseCases.AverageDataUseCase
import com.example.weatherapp.UseCases.AverageForecastsOfDayUseCase
import com.example.weatherapp.UseCases.AverageTomorrowForecastUseCase
import com.example.weatherapp.UseCases.DateListUseCase
import com.example.weatherapp.UseCases.DateUseCase
import com.example.weatherapp.UseCases.DayOfMonthUseCase
import com.example.weatherapp.UseCases.FiveDaysHourlyForecastToMapUseCase
import com.example.weatherapp.UseCases.FormatTempForAdapterUseCase
import com.example.weatherapp.UseCases.FormatedHourlyForecastListUseCase
import com.example.weatherapp.UseCases.HourlyForecastDataFromApiUseCase
import com.example.weatherapp.UseCases.IconUrlUseCase
import com.example.weatherapp.UseCases.TomorrowLiveDataOfForecastResponseForDayUseCase
import com.example.weatherapp.UseCases.LiveDataOfTomorrowHourlyForecastUseCase
import com.example.weatherapp.UseCases.MonthWithNumberToMonthWithWordsUseCase
import com.example.weatherapp.UseCases.RoundUseCase
import com.example.weatherapp.UseCases.TheLastStepForFiveDaysForecastUseCase
import com.example.weatherapp.UseCases.TheMostUsedWeatherIconInADayUseCAse
import com.example.weatherapp.UseCases.TimeUseCAse
import com.example.weatherapp.UseCases.TodayLiveDataOfForecastresponseForDayUseCase
import com.example.weatherapp.UseCases.TomorrowAndFiveDaysButtonsAreFalseUseCase
import com.example.weatherapp.UseCases.TomorrowButtonIsTrueUseCase
import com.example.weatherapp.UseCases.TomorrowDateUseCase
import com.example.weatherapp.UseCases.TomorrowDayOfMonthUseCase
import com.example.weatherapp.UseCases.TomorrowHourlyForecastListUseCase
import com.example.weatherapp.UseCases.UnixTimeToCurrentFormatUseCase
import com.example.weatherapp.UseCases.UseCaseCollector
import com.example.weatherapp.UseCases.WayThatFindTheMostUsedIconUseCase
import com.example.weatherapp.UseCases.WeatherDataFromApiUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Provides
    @Singleton
    fun getusecase(averageForecastsOfDayUseCase: AverageForecastsOfDayUseCase,
                   averageTomorrowForecastUseCase: AverageTomorrowForecastUseCase,
                   dateListUseCase: DateListUseCase,
                   dateUseCase: DateUseCase,
                   dayOfMonthUseCase: DayOfMonthUseCase,
                   fiveDaysHourlyForecastToMapUseCase: FiveDaysHourlyForecastToMapUseCase,
                   formatedHourlyForecastListUseCase: FormatedHourlyForecastListUseCase,
                   formatTempForAdapterUseCase: FormatTempForAdapterUseCase,
                   iconUrlUseCase: IconUrlUseCase,
                   monthWithNumberToMonthWithWords: MonthWithNumberToMonthWithWordsUseCase,
                   roundUseCase: RoundUseCase,
                   timeusecase : TimeUseCAse,
                   sumAverageDataUseCase: AverageDataUseCase,
                   theLastStepForFiveDaysForecastUseCase: TheLastStepForFiveDaysForecastUseCase,
                   mostUsedWeatherIconInADayUseCAse: TheMostUsedWeatherIconInADayUseCAse,
                   tomorrowDateUseCase: TomorrowDateUseCase,
                   tomorrowDayOfMonthUseCase: TomorrowDayOfMonthUseCase,
                   tomorrowHourlyForecastListUseCase: TomorrowHourlyForecastListUseCase,
                   unixTimeToCurrentFormatUseCase: UnixTimeToCurrentFormatUseCase,
                   wayThatFindTheMostUsedIconUseCase: WayThatFindTheMostUsedIconUseCase,
                   weatherDataFromApiUseCase: WeatherDataFromApiUseCase,
                   hourlyForecastDataFromApiUseCase: HourlyForecastDataFromApiUseCase,
                   tomorrowAndFiveDaysButtonsAreFalseUseCase: TomorrowAndFiveDaysButtonsAreFalseUseCase,
                   tomorrowButtonIsTrueUseCase: TomorrowButtonIsTrueUseCase,
                   liveDataOfTomorrowHourlyForecastUseCase: LiveDataOfTomorrowHourlyForecastUseCase,
                   liveDataOfForecastResponseForDayUseCsse: TomorrowLiveDataOfForecastResponseForDayUseCase,
                   todayLiveDataOfForecastresponseForDayUseCase: TodayLiveDataOfForecastresponseForDayUseCase):UseCaseCollector{
        return UseCaseCollector(averageForecastsOfDayUseCase,
            averageTomorrowForecastUseCase,
            dateListUseCase,
            dateUseCase,
            dayOfMonthUseCase,
            fiveDaysHourlyForecastToMapUseCase,
            formatedHourlyForecastListUseCase,
            formatTempForAdapterUseCase,
            iconUrlUseCase,
            monthWithNumberToMonthWithWords,
            roundUseCase,
            timeusecase,
            sumAverageDataUseCase,
            theLastStepForFiveDaysForecastUseCase,
            mostUsedWeatherIconInADayUseCAse,
            tomorrowDateUseCase,
            tomorrowDayOfMonthUseCase,
            tomorrowHourlyForecastListUseCase,
            unixTimeToCurrentFormatUseCase,
            wayThatFindTheMostUsedIconUseCase,weatherDataFromApiUseCase,hourlyForecastDataFromApiUseCase,
           tomorrowAndFiveDaysButtonsAreFalseUseCase,
            liveDataOfTomorrowHourlyForecastUseCase,
            tomorrowButtonIsTrueUseCase,
            liveDataOfForecastResponseForDayUseCsse,
            todayLiveDataOfForecastresponseForDayUseCase


            )
    }
}