package com.javiersc.kotlin.stdlib

public inline fun String.ansiColor(color: AnsiColor): String =
    lines().joinToString("\n") { line ->
        if (line.isNotBlank()) "${color}$line${AnsiColor.Reset}" else line
    }

public sealed class AnsiColor {

    public abstract val value: String

    override fun toString(): String = value

    public object Reset : AnsiColor() {
        override val value: String = "\u001B[0m"
    }

    public sealed class Foreground : AnsiColor() {

        public object Black : Foreground() {
            override val value: String = "\u001B[30m"
        }

        public object Red : Foreground() {
            override val value: String = "\u001B[31m"
        }

        public object Green : Foreground() {
            override val value: String = "\u001B[32m"
        }

        public object Yellow : Foreground() {
            override val value: String = "\u001B[33m"
        }

        public object Blue : Foreground() {
            override val value: String = "\u001B[34m"
        }

        public object Purple : Foreground() {
            override val value: String = "\u001B[35m"
        }

        public object Cyan : Foreground() {
            override val value: String = "\u001B[36m"
        }

        public object White : Foreground() {
            override val value: String = "\u001B[37m"
        }

        public object BrightBlack : Foreground() {
            override val value: String = "\u001B[90m"
        }

        public object BrightRed : Foreground() {
            override val value: String = "\u001B[91m"
        }

        public object BrightGreen : Foreground() {
            override val value: String = "\u001B[92m"
        }

        public object BrightYellow : Foreground() {
            override val value: String = "\u001B[93m"
        }

        public object BrightBlue : Foreground() {
            override val value: String = "\u001B[94m"
        }

        public object BrightPurple : Foreground() {
            override val value: String = "\u001B[95m"
        }

        public object BrightCyan : Foreground() {
            override val value: String = "\u001B[96m"
        }

        public object BrightWhite : Foreground() {
            override val value: String = "\u001B[97m"
        }
    }

    public sealed class Background : AnsiColor() {

        public object Black : Background() {
            override val value: String = "\u001B[40m"
        }

        public object Red : Background() {
            override val value: String = "\u001B[41m"
        }

        public object Green : Background() {
            override val value: String = "\u001B[42m"
        }

        public object Yellow : Background() {
            override val value: String = "\u001b[43m"
        }

        public object Blue : Background() {
            override val value: String = "\u001B[44m"
        }

        public object Purple : Background() {
            override val value: String = "\u001B[45m"
        }

        public object Cyan : Background() {
            override val value: String = "\u001B[46m"
        }

        public object Gray : Background() {
            override val value: String = "\u001B[47m"
        }
    }
}
