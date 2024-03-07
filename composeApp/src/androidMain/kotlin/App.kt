import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.greeting.MainViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(mainViewModel: MainViewModel) {
    MaterialTheme {
        val greetings by mainViewModel.greetingList.collectAsStateWithLifecycle()
        val lastRocketLaunchSucceed by mainViewModel.lastRocketLaunchSucceed.collectAsStateWithLifecycle()

        Column(
            modifier = Modifier.padding(all = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            lastRocketLaunchSucceed?.let {
                Text("Rocket:${if (it) "🚀" else "💥"}")
                Spacer(Modifier.height(16.dp))
            }
            greetings.forEach { greeting ->
                Text(greeting)
                Divider()
            }
        }
    }
}