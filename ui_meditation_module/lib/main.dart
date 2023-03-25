import 'package:flutter/material.dart';
import 'package:ui_meditation_module/book_screen.dart';
import 'package:ui_meditation_module/show_books.dart';

void main() {
  runApp(const App());
}

class App extends StatelessWidget {
  const App({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      routes: {
        "/show-books": (context) => const ShowBooks(),
        "/book": (context) => const BookScreen(),
      },
    );
  }
}
