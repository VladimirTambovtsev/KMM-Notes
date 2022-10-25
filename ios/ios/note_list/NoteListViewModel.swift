//
//  NoteListViewModel.swift
//  ios
//
//  Created by Владимир Тамбовцев on 24.10.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

extension NoteListScreen {
    @MainActor class NoteListViewModel: ObservableObject {
        private var noteDataSource: NoteDataSource? = nil
        
        private var notes =  [Note]()
        private var searchNotes = SearchNotes()
        
        @Published private (set) var filteredNotes = [Note]()
        @Published var searchText = "" {
            didSet {
                self.filteredNotes = searchNotes.execute(notes: self.notes, query: searchText)
            }
        }
        @Published private(set) var isSearchActive = false
        
        init(noteDataSource: NoteDataSource? = nil) {
            self.noteDataSource = noteDataSource
        }
        
        func loadNotes() {
            noteDataSource?.getAllNotes(completionHandler: { notes, err in
                if err != nil {
                    print("Err loading notes: \(String(describing: err?.localizedDescription))")
                    return
                }
                self.notes = notes ?? []
                self.filteredNotes = self.notes
            })
        }
        
        func deleteNoteById(id: Int64?) {
            if id != nil {
                noteDataSource?.deleteNoteById(id: id!, completionHandler: { err in
                    self.loadNotes()
                })
            }
        }
        
        func toggleSearchActive() {
            isSearchActive = !self.isSearchActive
            if !isSearchActive {
                searchText = ""
            }
        }
        
        func selfNoteDataSource(noteDataSource: NoteDataSource) {
            self.noteDataSource = noteDataSource
//            noteDataSource.insertNote(note: Note(id: nil, title: "Title", content: "Content", colorHex: 0xFF2355, created: DateTimeUtil().now())) { err in
//                if err != nil {
//                    print("Err selfNoteDataSource: \(err?.localizedDescription)")
//                }
//            }
        }
    }
}
