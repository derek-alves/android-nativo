import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:ui_meditation_module/pigeon.dart';

class ShowBooks extends StatefulWidget {
  const ShowBooks({Key? key}) : super(key: key);

  @override
  State<ShowBooks> createState() => _ShowBooksState();
}

class _ShowBooksState extends State<ShowBooks> {
  List<Widget> booksWidget = [];
  bool isLoading = false;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("books"),
          actions: [
            TextButton(
              onPressed: () async {
                await getBooks();
              },
              child: const Text("buscar livros"),
            )
          ],
        ),
        body: _buildBody());
  }

  Future getBooks() async {
    try {
      setState(() {
        isLoading = true;
      });
      final List<Book?> books = await BookApi().search("love");
      books.removeWhere((book) => book == null);
      for (var book in books) {
        if (book != null) booksWidget.add(_buildBookWidget(book));
      }
    } on PlatformException catch (e) {
      print("Aaaaaaaaaaaa");
    } finally {
      setState(() {
        isLoading = false;
      });
    }
  }

  Widget _buildBookWidget(Book book) {
    return Container(
      color: Colors.green,
      height: 29,
      width: double.maxFinite,
      padding: const EdgeInsets.all(8),
      child: Column(
        children: [
          Text(book.title ?? "Sem titulo"),
          Text(book.author ?? "Sem autor"),
        ],
      ),
    );
  }

  Widget _buildBody() {
    if (isLoading == true) {
      return const Center(
        child: CircularProgressIndicator(
          color: Colors.blue,
        ),
      );
    }
    if (booksWidget.isEmpty) {
      return Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Text(
            "Nenhum livro carregado",
            style: TextStyle(color: Colors.black, fontSize: 38),
          ),
          const SizedBox(
            height: 25,
          ),
          ElevatedButton(
            onPressed: () async {
              await getBooks();
            },
            child: const Text(
              "Buscar livros",
            ),
          )
        ],
      );
    }

    return ListView(
      children: booksWidget,
    );
  }
}
