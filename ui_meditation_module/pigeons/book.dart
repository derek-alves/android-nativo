import 'package:pigeon/pigeon.dart';

class Book {
  String? title;
  String? author;
}

@HostApi()
abstract class BookApi {
  List<Book?> search(String keyword);
}
