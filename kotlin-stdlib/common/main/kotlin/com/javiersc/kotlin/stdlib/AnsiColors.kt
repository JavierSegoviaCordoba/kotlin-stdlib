package com.javiersc.kotlin.stdlib

public inline fun String.ansiColor(color: AnsiColor): String =
    lines().joinToString("\n") { line -> "${color}$line${AnsiColor.Reset}" }

public abstract class AnsiColor {

    public abstract val value: String

    override fun toString(): String = value

    public object Reset : AnsiColor() {
        override val value: String = "\u001B[0m"
    }

    public object Foreground {
        public object Black : AnsiColor() {
            override val value: String = "\u001B[30m"
        }

        public object Red : AnsiColor() {
            override val value: String = "\u001B[31m"
        }

        public object Green : AnsiColor() {
            override val value: String = "\u001B[32m"
        }

        public object Yellow : AnsiColor() {
            override val value: String = "\u001B[33m"
        }

        public object Blue : AnsiColor() {
            override val value: String = "\u001B[34m"
        }

        public object Purple : AnsiColor() {
            override val value: String = "\u001B[35m"
        }

        public object Cyan : AnsiColor() {
            override val value: String = "\u001B[36m"
        }

        public object White : AnsiColor() {
            override val value: String = "\u001B[37m"
        }

        public object BrightBlack : AnsiColor() {
            override val value: String = "\u001B[90m"
        }

        public object BrightRed : AnsiColor() {
            override val value: String = "\u001B[91m"
        }

        public object BrightGreen : AnsiColor() {
            override val value: String = "\u001B[92m"
        }

        public object BrightYellow : AnsiColor() {
            override val value: String = "\u001B[93m"
        }

        public object BrightBlue : AnsiColor() {
            override val value: String = "\u001B[94m"
        }

        public object BrightPurple : AnsiColor() {
            override val value: String = "\u001B[95m"
        }

        public object BrightCyan : AnsiColor() {
            override val value: String = "\u001B[96m"
        }

        public object BrightWhite : AnsiColor() {
            override val value: String = "\u001B[97m"
        }
    }

    public object Background {
        public object Black : AnsiColor() {
            override val value: String = "\u001B[40m"
        }

        public object Red : AnsiColor() {
            override val value: String = "\u001B[41m"
        }

        public object Green : AnsiColor() {
            override val value: String = "\u001B[42m"
        }

        public object Yellow : AnsiColor() {
            override val value: String = "\u001b[43m"
        }

        public object Blue : AnsiColor() {
            override val value: String = "\u001B[44m"
        }

        public object Purple : AnsiColor() {
            override val value: String = "\u001B[45m"
        }

        public object Cyan : AnsiColor() {
            override val value: String = "\u001B[46m"
        }

        public object Gray : AnsiColor() {
            override val value: String = "\u001B[47m"
        }
    }
}
