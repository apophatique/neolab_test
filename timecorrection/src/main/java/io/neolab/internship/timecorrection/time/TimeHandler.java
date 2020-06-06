package io.neolab.internship.timecorrection.time;


/**
 * Class that provides an actions to handle a time.
 */
public final class TimeHandler {
    private static final int SECONDS_MAX_NUMBER = 60;
    private static final int MINUTES_MAX_NUMBER = 60;
    private static final int HOURS_MAX_NUMBER = 24;

    /**
     * Task function.
     * This function returns a string converted to normal HH:MM:SS format.
     *
     * @param inputString {@link String} string to format.
     * @return {@link String} formatted string.
     */
    public static String formatDate(final String inputString) throws TimeValidFormatException {
        if (inputString.equals("")) {
            return inputString;
        }

        String patternCompileString = "^$|(\\d+:\\d+:\\d+)";
        if (!inputString.matches(patternCompileString)) {
            throw new TimeValidFormatException("");
        }

        String[] dateComponents = inputString.split(":");
        int hours = Integer.parseInt(dateComponents[0]);
        int minutes = Integer.parseInt(dateComponents[1]);
        int seconds = Integer.parseInt(dateComponents[2]);


        int additionalMinutes = seconds / SECONDS_MAX_NUMBER;
        seconds = seconds % SECONDS_MAX_NUMBER;
        int additionalHours = (minutes + additionalMinutes) / MINUTES_MAX_NUMBER;
        minutes = (minutes + additionalMinutes) % MINUTES_MAX_NUMBER;
        hours = (hours + additionalHours) % HOURS_MAX_NUMBER;


        String stringSeconds = Integer.toString(seconds);
        String stringMinutes = Integer.toString(minutes);
        String stringHours = Integer.toString(hours);


        stringSeconds = String.format("%2s", stringSeconds).replace(' ', '0');
        stringMinutes = String.format("%2s", stringMinutes).replace(' ', '0');
        stringHours = String.format("%2s", stringHours).replace(' ', '0');


        String joinSymbol = ":";
        return String.join(joinSymbol,
                stringHours,
                stringMinutes,
                stringSeconds);
    }
}