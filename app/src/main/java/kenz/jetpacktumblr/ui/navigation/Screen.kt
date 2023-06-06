package kenz.jetpacktumblr.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailTumblr : Screen("home/{detailId}") {
        fun createRoute(detailId: Long) = "home/$detailId"
    }
}