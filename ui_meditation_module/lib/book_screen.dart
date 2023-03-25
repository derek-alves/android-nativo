import 'package:flutter/material.dart';

class BookScreen extends StatelessWidget {
  const BookScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Book'),
      ),
      body: Container(
        color: const Color.fromARGB(255, 135, 196, 247),
        child: const Center(
          child: Text(
            "BOOOOK",
            style: TextStyle(color: Colors.black, fontSize: 38),
          ),
        ),
      ),
    );
  }
}
