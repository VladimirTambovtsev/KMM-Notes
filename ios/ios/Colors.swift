//
//  Colors.swift
//  ios
//
//  Created by Владимир Тамбовцев on 24.10.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension Color {
    init(hex: Int64, alpha: Double = 1) {
        self.init(.sRGB,
                  red: Double((hex >> 16) & 0xff) / 255,
                  green: Double((hex >> 08) & 0xff) / 255,
                  blue: Double((hex >> 00) & 0xff) / 255,
                  opacity: alpha
        )
    }
}
